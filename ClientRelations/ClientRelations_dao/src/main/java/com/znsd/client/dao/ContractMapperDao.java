package com.znsd.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Contract;
import com.znsd.client.bean.Genre;
import com.znsd.client.bean.Shape;
import com.znsd.client.bean.Staff;
import com.znsd.client.vo.ContractVo;
import com.znsd.client.vo.RoleVo;
import com.znsd.client.vo.StaffVo;
@Repository
public interface ContractMapperDao {
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 查询状态
	*
	 */
	public List<Shape> selectShape();
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 分页条件查询合同询
	*
	 */
	public List<ContractVo> selectContractByPage(@Param("contractName")String contractName,@Param("contractState")String contractState,@Param("contractType")String contractType);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 增加合同
	*
	 */
	public int addContract(List<Contract> list);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 修改合同
	*
	 */
	public int updateContract(Contract con);
	
	public List<Contract> selectContractAll(int contractId);
	
	public List<Contract> selectDetails(int contractId);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 查询详情
	*
	 */

	public List<Genre> selectGenre();
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 查询类型
	*
	 */
	
	public List<Contract> selectRepetition(String contractName);
	
	public List<RoleVo> selectRole();
	
	public List<Staff> selectStaff();
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 查询员工
	*
	 */
	
	public List<StaffVo> selectEingereicht(int contractId);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同提交查询
	*
	 */
	
	public int updateSubmit(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同提交
	*
	 */
	
	public List<Contract> selectCredit(int contractId);
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同执行查询
	*
	 */
	
	public int updateExamine(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同审核
	*
	 */
	
	public int updatePower(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同执行
	*
	 */
	
	public int updatePolicy(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同变更
	*
	 */
	
	public int updateDispel(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同解除
	*
	 */
	
	public int updateRepulse(Contract con);
	
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同打回
	*
	 */
	
	public int updateLetter(Contract con);

	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 合同转让
	*
	 */
}
