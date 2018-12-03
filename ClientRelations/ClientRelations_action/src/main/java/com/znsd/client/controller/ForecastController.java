package com.znsd.client.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Forecast;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.service.ForecastService;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class ForecastController {
	@Autowired
	private ForecastService forecastBiz;
	@Autowired
	private DepartmentService departBiz;
	
	private Map<String,Object> map = new HashMap<String,Object>();//用于接东西
	@RequestMapping("selectForecastPage")
	@ResponseBody
	public Map<String,Object> selectForecastPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam(name="name",required=false) String startTime) {
		Page<Object> pages = PageHelper.startPage(page, limit);
		map.put("data",forecastBiz.selectForecastByPage(startTime));
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
	
	@RequestMapping("selectBranceNumberData")
	@ResponseBody
	public Map<String,Object> selectBranceNumberData(@RequestParam("branceId") Integer branceId,@RequestParam("referDate") String referDate) {
		map.put("sectorScale",forecastBiz.selectDateStaffNumber(branceId,referDate));
		map.put("clientNumber",forecastBiz.selectDateClientNumber(branceId,referDate));
		return map;
	}
	
	
	
	
	@RequestMapping("getBranceData")
	@ResponseBody
	public Map<String,Object> getBranceData() {
		map.put("data",departBiz.selectDepartmentByPage(null));
		return map;
	}
	/**
	 * 
	*	@author    Administrator
	*	@param forecast
	*	@return
	*	@return    Map<String,Object>
	*	@time    2018 下午5:34:01
	*	@desc 预测
	*
	 */
	@RequestMapping("addForecast")
	@ResponseBody
	public Map<String,Object> addForecast(Forecast forecast,HttpServletRequest request){
		StringBuffer content = new StringBuffer("目前公司共有客户"+forecast.getClientNumber()+",");
		getClientNumber(forecast.getBranchId(),forecast.getClientNumber(),content);
		content.append(forecast.getSectorScale()+"人,");
		getSectorScale(forecast.getBranchId(),forecast.getSectorScale(),content);
		forecast.setForecastContent(content.toString());
		forecast.setOperatorId(getUser(request).getStaffId());
		forecastBiz.addForecast(forecast);
		map.put("msg","已成功预测");
		map.put("code",0);
		return map;
	}
	
	
	/**
	 * 
	*	@author    Administrator
	*	@param request
	*	@return
	*	@return    StaffLoginVo
	*	@time    2018 下午3:06:34
	*	@desc 获取登入对象
	*
	 */
	public StaffLoginVo getUser(HttpServletRequest request) {
		return (StaffLoginVo) request.getSession().getAttribute("userInfo");
	}
	
	
	
	/**
	 * 
	*	@author    Administrator
	*	@return
	*	@return    String
	*	@time    2018 下午3:12:11
	*	@desc 获取上个月日期
	*
	 */
	public String getLastMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance(); 
	    c.add(Calendar.MONTH, -1); 
		return sdf.format(c.getTime());
	}
	/**
	 * 
	*	@author    Administrator
	*	@return
	*	@return    String
	*	@time    2018 下午3:12:11
	*	@desc 获取上一年日期
	*
	 */
	public String getLastYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance(); 
	    c.add(Calendar.YEAR, -1); 
		return sdf.format(c.getTime());
	}
	
	
	public void getClientNumber(Integer branceId,Integer clientNumber,StringBuffer content) {
		Integer monthClientNumber = forecastBiz.selectDateClientNumber(branceId,getLastMonth());//上个月的销售员工数量
		Integer yearClientNumber = forecastBiz.selectDateClientNumber(branceId,getLastYear());//去年的销售员工数量
		if (clientNumber == 0) {
			content.append("同比增长+0%，环比增长+0%；");
		}else {
			if (yearClientNumber == 0) {
				content.append("同比增长+0%，");
			}else {
				content.append("同比增长+"+reckon(clientNumber,yearClientNumber)+"%；");
			}
			if (monthClientNumber == 0) {
				content.append("环比增长+0%，市场发展部员工");
			}else {
				content.append("环比增长+"+reckon(clientNumber,monthClientNumber)+"%；市场发展部员工");
			}
		}
	}
	public void getSectorScale(Integer branceId,Integer sectorScale,StringBuffer content) {
		Integer monthSectorScale = forecastBiz.selectDateStaffNumber(branceId,getLastMonth());//上个月的销售员工数量
		Integer yearSectorScale = forecastBiz.selectDateStaffNumber(branceId,getLastYear());//去年的销售员工数量
		if (sectorScale == 0) {
			content.append("同比增长+0%,环比增长+0%；");
		}else {
			if (yearSectorScale == 0) {
				content.append("同比增长+0%,");
			}else {
				content.append("同比增长+"+reckon(sectorScale,yearSectorScale)+"%,");
			}
			if (monthSectorScale == 0) {
				content.append("环比增长+0%,目前行业正处于销售旺季预计目标时间内销售额在50~1000万元之间，同比将增加多少我也不知道");
			}else {
				content.append("环比增长+"+reckon(sectorScale,monthSectorScale)+"%；目前行业正处于销售旺季预计目标时间内销售额在50~1000万元之间，同比将增加多少我也不知道");
			}
		}
	}
	
	public String reckon(int now,int before) {
		/*if (now == before) {
			return "0";
		}*/
		double d =(double) (now-before)/4*100;
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(d);
	}
	
}	 