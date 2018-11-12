package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Shape;

@Repository
public interface ContractMapperDao {
	
	public List<Shape> selectShape();
}
