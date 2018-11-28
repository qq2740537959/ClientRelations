package com.znsd.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.alipay.config.AlipayConfig;
import com.znsd.client.bean.Address;
import com.znsd.client.bean.OrderIndent;
import com.znsd.client.bean.Product;
import com.znsd.client.bean.ResultData;
import com.znsd.client.service.AddressService;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.OrderIndentService;
import com.znsd.client.service.ProductService;
import com.znsd.client.vo.ClientVo;

@Controller
@RequestMapping("/")
public class ClientResourceController{
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderIndentService orderIndentService;
	@RequestMapping("/selectClient")
	public @ResponseBody ResultData selectClient(@RequestParam("staffId") Integer staffId,@RequestParam(value="distinguish",required=false) String distinguish,@RequestParam(value="clientNameOrPhone",required=false) String clientNameOrPhone,@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) {
		//按销售代表查询客户信息
		if(distinguish == null) {
			distinguish = "";
		}
		if(clientNameOrPhone == null) {
			clientNameOrPhone = "";
		}
		if(distinguish.equals("clientName")) {
			clientNameOrPhone = "%"+clientNameOrPhone+"%";
		}
		if(page == null) {
			page = 1;
		}
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<ClientVo> clientVo = clientService.selectClientInfoByPage(staffId, distinguish, clientNameOrPhone);
		ResultData result = new ResultData();
		result.setCode(0);
		result.setCount(Long.valueOf(pages.getTotal()));//总条数
		result.setMsg("");
		result.setData(clientVo);//客户数据
		return result;
	}
	@RequestMapping("/selectClientById")
	public @ResponseBody ClientVo selectClientIdByPage(@RequestParam("clientId") Integer clientId) {
		//按客户id查询客户信息
		ClientVo client;
		client = clientService.selectClientById(clientId);
		return client;
	}
	@RequestMapping("/selectProduct")
	public @ResponseBody ResultData selectProduct(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) {
		//查询所有商品 
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Product> productList = productService.selectProductByPage();
		ResultData result = new ResultData();
		result.setCode(0);
		result.setCount(Long.valueOf(pages.getTotal()));//总条数
		result.setMsg("");
		result.setData(productList);//商品数据
		return result;
	}
	@RequestMapping("/selectProductById")
	public @ResponseBody ResultData selectProductById(@RequestParam(value="product",required=false,defaultValue="") String product) {
		//查询包含商品id的商品 
		String [] ary = product.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ary.length; i++) {
			list.add(Integer.valueOf(ary[i]));
		}
		List<Product> productList = productService.selectProductById(list);
		ResultData result = new ResultData();
		result.setCode(0);
		result.setMsg("");
		result.setData(productList);//商品数据
		return result;
	}
	@RequestMapping("/addAddress")
	public @ResponseBody String selectAddress(@RequestParam(value="clientId",required=false) Integer clientId,@RequestParam(value="province",required=false) String province,@RequestParam(value="area",required=false) String area,@RequestParam(value="city",required=false) String city,@RequestParam(value="consigneeName",required=false) String consigneeName,@RequestParam(value="detailAddress",required=false) String detailAddress,@RequestParam(value="phone",required=false) String phone) {
		//添加收货地址
		Address address = new Address();
		address.setClientId(clientId);
		address.setProvince(province);
		address.setArea(area);
		address.setCity(city);
		address.setConsigneeName(consigneeName);
		address.setDetailAddress(detailAddress);
		address.setPhone(phone);
		int a = addressService.addAddress(address);
		return "success";
	}
	@RequestMapping("/updateAddress")
	public String updateAddress(@RequestParam(value="clientId",required=false) Integer clientId,@RequestParam(value="province",required=false) String province,@RequestParam(value="area",required=false) String area,@RequestParam(value="city",required=false) String city,@RequestParam(value="consigneeName",required=false) String consigneeName,@RequestParam(value="detailAddress",required=false) String detailAddress,@RequestParam(value="phone",required=false) String phone) {
		//修改收货地址
		Address address = new Address();
		address.setConsigneeName(consigneeName);
		address.setPhone(phone);
		address.setProvince(province);
		address.setCity(city);
		address.setArea(area);
		address.setDetailAddress(detailAddress);
		address.setClientId(clientId);
		int a = addressService.updateAddress(address);
		String result = "";
		if(a!=-1) {
			result = "success";
		}
		return result;
	}
	
	@RequestMapping("/selectAddressByClidentId")
	public @ResponseBody Address selectAddressByClidentId(@RequestParam("clientId") Integer clientId) {
		Address address = new Address();	
		address = addressService.selectAddessByClientId(clientId);
		return address;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/projectPay",produces= {"application/html;charset=utf-8"})
	public void pay(OrderIndent orderIndent,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		//在线支付
		Random random = new Random();
		Date vNow = new Date();
		String orderCode = getOrderNumber();
		orderIndent.setOrderCode(orderCode);
		orderIndent.setOrderStatus("待付款");
		orderIndent.setModeOfDistribution("快递包邮");
		
		int resu = orderIndentService.addOrder(orderIndent);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		try {
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderCode +"\"," 
					+ "\"total_amount\":\""+ orderIndent.getOrderMoney() +"\"," 
					+ "\"subject\":\""+ orderIndent.getCommodity() +"\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			
			//请求
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			
			//输出
			PrintWriter out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/cashOnDelivery",produces= {"application/html;charset=utf-8"})
	public String pays(OrderIndent orderIndent){
		//货到付款
		Random random = new Random();
		Date vNow = new Date();
		String orderCode = getOrderNumber();
		orderIndent.setOrderCode(orderCode);
		orderIndent.setModeOfPayment("货到付款");
		orderIndent.setOrderStatus("待收货");
		orderIndent.setModeOfDistribution("公司送货上门");
		int resu = orderIndentService.addOrder(orderIndent);
		return "admin/views/orderManager/changeHands.jsp";
	}
	public static String getOrderNumber() {
		//格式化当前时间
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date());
		//得到17位时间如：20170411094039080
		/*System.out.println("时间17位：" + strDate);*/
		//为了防止高并发重复,再获取3个随机数
		String random = getRandom620(3);
		
		//最后得到20位订单编号。
		/*System.out.println("订单号20位：" + strDate + random);*/
		return strDate+random+"";
	}
	
	/**
	 * 获取6-10 的随机位数数字
	 * @param length	想要生成的长度
	 * @return result
	 */
	public static String getRandom620(Integer length) {
		String result = "";
		Random rand = new Random();
		int n = 20;
		if (null != length && length > 0) {
			n = length;
		}
		int randInt = 0;
		for (int i = 0; i < n; i++) {
			randInt = rand.nextInt(10);
			result += randInt;
		}
		return result;
	}
	
	
	@RequestMapping("/reduceProductNumber")
	public @ResponseBody String reduceProductNumber(@RequestParam(value="productNumber",required=false) String productNumber) {
		//商品购买后减少
		System.out.println("productNumber"+productNumber);
		int result = -1;
		String [] ary = productNumber.split("-");
		String [][] arr = new String [ary.length][];
		for (int i = 0; i < ary.length; i++) {
			String[] tempAgain = ary[i].split(","); //继续分割并存到另一个一临时的一维数组当中
			arr[i] = new String[tempAgain.length]; //
			for (int j = 0; j < tempAgain.length; j++) {
				arr[i][j] = tempAgain[j];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			result = productService.reduceProductNumber(Integer.valueOf(arr[i][0]),Integer.valueOf(arr[i][1]));
		}
		return "success";
	}
}
