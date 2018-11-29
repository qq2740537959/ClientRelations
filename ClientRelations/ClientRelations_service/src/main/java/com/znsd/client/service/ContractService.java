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
	
	public List<Shape> selectShape();
	
	public List<ContractVo> selectContractByPage(String contractName,String contractState,String contractType);
	
	public int addContract(List<Contract> list);
	
	public int updateContract(Contract con);
	
	public List<Contract> selectContractAll(int contractId);
	
	public List<Contract> selectDetails(int contractId);
	
	public List<Genre> selectGenre();
	
	public List<Contract> selectRepetition(String contractName);
	
	public List<RoleVo> selectRole();
	
	public List<Staff> selectStaff();
	
	public List<StaffVo> selectEingereicht(int contractId);
	
	public int updateSubmit(Contract con);
	
	public List<Contract> selectCredit(int contractId);
	
	public int updateExamine(Contract con);
	
	public int updatePower(Contract con);
	
	public int updatePolicy(Contract con);
	
	public int updateDispel(Contract con);
	
	public int updateRepulse(Contract con);
}
