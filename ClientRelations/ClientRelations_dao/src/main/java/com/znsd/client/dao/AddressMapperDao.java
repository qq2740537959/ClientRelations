package com.znsd.client.dao;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Address;

@Repository
public interface AddressMapperDao {
	//添加收货地址
	public int addAddress(Address address);
	
	//按客户id查询收货地址信息
	public Address selectAddessByClientId(Integer clidentId);
	
	//修改收货地址
	public int updateAddess(Address address);
}
