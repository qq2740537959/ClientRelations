package com.znsd.client.bean;

public class ResultData<T> {
	private Integer code;
	private String msg;
	private Long count;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResultData(Integer code, String msg, Long count, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public ResultData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResultData [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
	
}
