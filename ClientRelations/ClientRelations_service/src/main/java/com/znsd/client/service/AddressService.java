package com.znsd.client.service;

import com.znsd.client.bean.Address;
public interface AddressService {
	//添加收货地址
	public int addAddress(Address address);
	
	//按客户id查询收货地址信息
	public Address selectAddessByClientId(Integer clidentId);
	
	//修改收货地址
	public int updateAddress(Address address);
}
