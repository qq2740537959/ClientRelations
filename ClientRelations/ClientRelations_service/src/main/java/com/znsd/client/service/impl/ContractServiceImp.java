package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Contract;
import com.znsd.client.bean.Genre;
import com.znsd.client.bean.Shape;
import com.znsd.client.bean.Staff;
import com.znsd.client.bean.TopTree;
import com.znsd.client.dao.ContractMapperDao;
import com.znsd.client.service.ContractService;
import com.znsd.client.vo.ContractVo;
import com.znsd.client.vo.RoleVo;
import com.znsd.client.vo.StaffVo;

@Service
public class ContractServiceImp implements ContractService{
	
	@Autowired
	private ContractMapperDao dao;
	
	public List<Shape> selectShape() {
		return dao.selectShape();
	}

	public int addContract(List<Contract> list) {
		
		return dao.addContract(list);
	}

	public int updateContract(Contract con) {
		return dao.updateContract(con);
	}

	public List<Contract> selectContractAll(int contractId) {
		return dao.selectContractAll(contractId);
	}

	public List<Contract> selectDetails(int contractId) {
		return dao.selectDetails(contractId);
	}

	public List<Genre> selectGenre() {
		return dao.selectGenre();
	}

	public List<ContractVo> selectContractByPage(String contractName, String contractState, String contractType) {
		return dao.selectContractByPage(contractName, contractState, contractType);
	}

	public List<Contract> selectRepetition(String contractName) {
		return dao.selectRepetition(contractName);
	}

	@Override
	public List<RoleVo> selectRole() {
		return dao.selectRole();
	}

	@Override
	public List<Staff> selectStaff() {
		return dao.selectStaff();
	}

	@Override
	public List<StaffVo> selectEingereicht(int contractId) {
		return dao.selectEingereicht(contractId);
	}

	@Override
	public int updateSubmit(Contract con) {
		return dao.updateSubmit(con);
	}

	@Override
	public List<Contract> selectCredit(int contractId) {
		return dao.selectCredit(contractId);
	}

	@Override
	public int updateExamine(Contract con) {
		return dao.updateExamine(con);
	}

	@Override
	public int updatePower(Contract con) {
		return dao.updatePower(con);
	}

	@Override
	public int updatePolicy(Contract con) {
		return dao.updatePolicy(con);
	}

	@Override
	public int updateDispel(Contract con) {
		return dao.updateDispel(con);
	}

	@Override
	public int updateRepulse(Contract con) {
		return dao.updateRepulse(con);
	}

	@Override
	public int updateLetter(Contract con) {
		return dao.updateLetter(con);
	}

	@Override
	public List<Contract> Institution() {
		return dao.Institution();
	}
}
