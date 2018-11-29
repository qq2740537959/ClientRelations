package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the vie_manager database table.
 * 
 */


public class VieManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int analysisCategory;
	private String analysisFruit;
	private Date createTime;
	private int operatorId;
	private String vieAnalysis;
	private int vieState;

	public VieManager() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public int getAnalysisCategory() {
		return this.analysisCategory;
	}

	public void setAnalysisCategory(int analysisCategory) {
		this.analysisCategory = analysisCategory;
	}


	
	public String getAnalysisFruit() {
		return this.analysisFruit;
	}

	public void setAnalysisFruit(String analysisFruit) {
		this.analysisFruit = analysisFruit;
	}


	
	
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	
	public int getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}


	
	public String getVieAnalysis() {
		return this.vieAnalysis;
	}

	public void setVieAnalysis(String vieAnalysis) {
		this.vieAnalysis = vieAnalysis;
	}


	
	public int getVieState() {
		return this.vieState;
	}

	public void setVieState(int vieState) {
		this.vieState = vieState;
	}

}