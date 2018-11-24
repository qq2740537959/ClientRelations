package com.znsd.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.alipay.config.AlipayConfig;
import com.znsd.client.bean.ResultData;
import com.znsd.client.service.OrderIndentService;
import com.znsd.client.vo.OrderIndentVo;
import com.znsd.client.vo.OrderStatisticsVo;

@Controller
@RequestMapping("/")
public class OrderIndentController{
	@Autowired
	private OrderIndentService orderIndentService;
	
	
	@RequestMapping("/selectOrder")
	public @ResponseBody ResultData selectOrder(@RequestParam("page") Integer page,@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="differentiate",required=false) String differentiate,@RequestParam(value="inputSelect",required=false) String inputSelect,@RequestParam(value="dealTime",required=false) String dealTime,@RequestParam(value="status",required=false) String status) {
		//订单查询
		Page pages = PageHelper.startPage(page, limit);
		if(page == null) {
			page = 1;
		}
		if(null == inputSelect) {
			inputSelect = "";
		}
		List<OrderIndentVo> orderVo = orderIndentService.selectOrderIndent(differentiate, inputSelect, dealTime, status);
		ResultData result = new ResultData();
		result.setCode(0);
		result.setMsg("");
		result.setData(orderVo);
		result.setCount(Long.valueOf(pages.getTotal()));
		return result;
	}
	
	@RequestMapping("/orderStatistics")
	public @ResponseBody ResultData orderStatistics(@RequestParam(value="page",required=false) Integer page,@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="date",required=false) String date){
		//订单统计
		if(page == null) {
			page = 1;
		}
		String [] dateAry = {"",""};
		if(null != date) {
			dateAry[0] = date.substring(0, 10);
			dateAry[1] = date.substring(12,23);
		}
		System.out.println("---date---"+date);
		System.out.println(dateAry[0]+"**********"+dateAry[1]);
		Page pages = PageHelper.startPage(page, limit);
		List<OrderStatisticsVo> orderStatisticsVo = orderIndentService.orderStatistics(dateAry[0],dateAry[1]);
		ResultData result = new ResultData();
		result.setCode(0);
		result.setMsg("");
		result.setData(orderStatisticsVo);
		result.setCount(Long.valueOf(pages.getTotal()));
		return result;
	}
	@RequestMapping("/notifyUrl")
	public void notifyUrl(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//支付宝验证是否支付成功
		System.out.println("支付成功后异步通知处理。。。。。。");
		/*
		 * 1. 获取支付宝响应数据 2. 验证 1. 去除 签名，签名状态 2. 字典排序 3. base64解码 4. 使用RSA 使用支付宝提供的帮助类完成
		 * boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap,
		 * ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE) //调用SDK验证签名 3.
		 * 
		 * 
		 */
		PrintWriter out = response.getWriter();

		Map<String, String[]> requestMap = request.getParameterMap();
		Map<String, String> paramsMap = new HashMap<String,String>();

		for (String key : requestMap.keySet()) {
			paramsMap.put(key, requestMap.get(key)[0]);
		}

		System.out.println("----------支付宝响应数据-----------");
		System.out.println(JSON.toJSONString(requestMap));
		System.out.println(JSON.toJSONString(paramsMap));
		
		boolean signVerified = true;
		try {
			signVerified = AlipaySignature.rsaCheckV2(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
			out.write("error");
		}
		System.out.println("signVerified:"+signVerified+"----"+paramsMap.get("out_trade_no"));
		String order_number = order_number = paramsMap.get("out_trade_no");
		if (signVerified) {
			// 1. 订单号是否是系统订单号
			// 2. 验证订单号对应的金额是否登录支付宝返回的金额
			// 3. AAPI是否是自己的ID
			// 4. seller_id
			// 订单状态修改为支付异常[待支付，支付异常，支付成功]
			// 修改订单支付状态为成功状态，且返回success 给支付宝
			
			//交易成功，修改订单状态
			int result = orderIndentService.updateOrderStatus("等待收货",order_number);
			
			out.write("success");

		} else {
			int result = orderIndentService.updateOrderStatus("待付款",order_number);
			out.write("error");
		}
		out.flush();
		out.close();
	}
}
