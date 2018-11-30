package com.znsd.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Address;
import com.znsd.client.dao.AddressMapperDao;
import com.znsd.client.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressMapperDao dao;
	public int addAddress(Address address) {
		//添加收货地址
		return dao.addAddress(address);
	}
	public Address selectAddessByClientId(Integer clidentId) {
		//按客户id查询收货地址信息
		return dao.selectAddessByClientId(clidentId);
	}
	public int updateAddress(Address address) {
		//修改收货地址
		return dao.updateAddess(address);
	}

}
