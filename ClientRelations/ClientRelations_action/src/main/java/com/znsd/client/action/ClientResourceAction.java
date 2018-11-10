package com.znsd.client.action;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.znsd.client.bean.Contract;
import com.znsd.client.bean.Shape;

public interface ClientResourceAction {
	@Select("select * from contract")
	@Results({
		@Result(property = "contractName",column = "contract_name"),
		@Result(property = "contractType",column = "contract_type"),
		@Result(property = "contractName",column = "contract_name"),
		@Result(property = "contractName",column = "contract_name"),
	})
	public List<Contract> selectContractByPage();
	
	
	@Select("select * from shape")
	@Results({
		@Result(property = "shapeId",column = "shape_id"),
		@Result(property = "shapeName",column = "shape_name"),
	})
	public List<Shape> selectShape();
}
