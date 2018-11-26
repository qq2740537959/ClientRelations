package com.znsd.client.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Product;
import com.znsd.client.bean.ResultData;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.ProductService;
import com.znsd.client.vo.ClientVo;

@Controller
public class ClientResourceAction {
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;
	
	private List<ClientVo> clientVo = new ArrayList<ClientVo>();
	private ClientVo client;
	private List<Product> productList = new ArrayList<Product>(); 
	private Integer clientId;
	private String distinguish;
	private Integer staffId;
	private String clientNameOrPhone;
	private Integer limit;
	private Integer page;
	private ResultData result = new ResultData();
	private String product;
	/*@Action(value="selectClientAction",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","result"})
	})*/
	@RequestMapping("/selectClientAction")
	public String selectClient() {
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
		clientVo = clientService.selectClientInfoByPage(staffId, distinguish, clientNameOrPhone);
		
		result.setCode(0);
		result.setCount(Long.valueOf(pages.getTotal()));//总条数
		result.setMsg("");
		result.setData(clientVo);//客户数据
		return /*SUCCESS*/"";
	}
	/*@Action(value="selectClientByIdAction",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","client"})
	})*/
	@RequestMapping("/selectClientByIdAction")
	public String selectClientIdByPage() {
		//按客户id查询客户信息
		client = clientService.selectClientById(clientId);
		return /*SUCCESS*/"";
	}
	/*@Action(value="selectProductAction",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","result"})
	})*/
	@RequestMapping("/selectProductAction")
	public String selectProduct() {
		//查询所有商品 
		Page<Object> pages = PageHelper.startPage(page, limit);
		productList = productService.selectProductByPage();
		result.setCode(0);
		result.setCount(Long.valueOf(pages.getTotal()));//总条数
		result.setMsg("");
		result.setData(productList);//商品数据
		return /*SUCCESS*/"";
	}
/*	@Action(value="selectProductByIdAction",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","result"})
	})*/
	@RequestMapping("/selectProductByIdAction")
	public String selectProductById() {
		//查询包含商品id的商品 
		String [] ary = product.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ary.length; i++) {
			list.add(Integer.valueOf(ary[i]));
		}
		productList = productService.selectProductById(list);
		result.setCode(0);
		result.setMsg("");
		result.setData(productList);//商品数据
		return /*SUCCESS*/""	;
	}
	public List<ClientVo> getClientVo() {
		return clientVo;
	}
	public void setClientVo(List<ClientVo> clientVo) {
		this.clientVo = clientVo;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getDistinguish() {
		return distinguish;
	}
	public void setDistinguish(String distinguish) {
		this.distinguish = distinguish;
	}
	public String getClientNameOrPhone() {
		return clientNameOrPhone;
	}
	public void setClientNameOrPhone(String clientNameOrPhone) {
		this.clientNameOrPhone = clientNameOrPhone;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public ResultData getResult() {
		return result;
	}
	public void setResult(ResultData result) {
		this.result = result;
	}
	public ClientVo getClient() {
		return client;
	}
	public void setClient(ClientVo client) {
		this.client = client;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
}
