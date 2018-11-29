package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Contract;
import com.znsd.client.bean.Genre;
import com.znsd.client.bean.Shape;
import com.znsd.client.bean.Staff;
import com.znsd.client.vo.ContractVo;
import com.znsd.client.vo.RoleVo;
import com.znsd.client.vo.StaffVo;

public interface ContractService {
	
	//查询状态
	public List<Shape> selectShape();
	
	//分页条件查询合同
	public List<ContractVo> selectContractByPage(String contractName,String contractState,String contractType);
	
	//增加合同
	public int addContract(List<Contract> list);
	
	public int updateContract(Contract con);
	
	public List<Contract> selectContractAll(int contractId);
	
	//查询详情
	public List<Contract> selectDetails(int contractId);
	
	//查询类型
	public List<Genre> selectGenre();
	
	public List<Contract> selectRepetition(String contractName);
	
	public List<RoleVo> selectRole();
	
	//查询员工
	public List<Staff> selectStaff();
	
	//合同提交查询
	public List<StaffVo> selectEingereicht(int contractId);
	
	//合同提交
	public int updateSubmit(Contract con);
	
	//合同执行查询
	public List<Contract> selectCredit(int contractId);
	
	//合同审核
	public int updateExamine(Contract con);
	
	//合同执行
	public int updatePower(Contract con);
	
	//合同变更
	public int updatePolicy(Contract con);
	
	//合同解除
	public int updateDispel(Contract con);
	
	//合同打回
	public int updateRepulse(Contract con);
	
	//合同转让
	public int updateLetter(Contract con);
}
