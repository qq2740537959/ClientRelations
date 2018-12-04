package com.znsd.client.utils;

public class Constant {
	public static final int ZERO = 0;  
	public static final int STATE1 = 1;
    public static final int STATE2 = 2;
    public static final int STATE3 = 3;
    public static final int STATE4 = 4;
    public static final int STATE5 = 5;
    public static final String SUCCESS = "success";  
    public static final String ERROR = "error";
    public static final String ADD_SUCCESS = "增加成功！";
    public static final String DELETE_SUCCESS = "删除成功！";
    public static final String UPDATE_SUCCESS = "修改成功！";
    public static final String OPERATE_SUCCESS = "操作成功！"; 
    public static final String ADD_ERROR = "增加失败！";  
    public static final String DELETE_ERROR = "删除失败！";
    public static final String UPDATE_ERROR = "修改失败！";
    public static final String OPERATE_ERROR = "操作失败！";  
    public static final String NOT_PERMITTED = "权限不足！";
    public static final String FORM_EMPTY = "请将表单填写完整后提交！";
    public static final String NOT_DO_OPERATE = "未做任何修改操作！";
    
    //员工登录
    public static final String LOGIN_SUCCESS = "登录成功！";
    public static final String LOGIN_ERROR = "用户名或密码错误！";
    public static final String ACCOUNT_FROZEN = "账号冻结，联系管理员！";
    
    //修改密码
    public static final String PRIMARY_PASSWORD_ERROR = "原密码输入错误!"; 
    public static final String NEW_OLD_PASSWORD_CANNOT_EQALS = "新密码不能跟旧密码相等!"; 
    public static final String NEW_PASSWORD_FORMAT_INCORRECT = "新密码格式不正确!"; 
    public static final String TWO_PASSWORD_ATYPISM = "两次密码输入不一致!"; 
    
    //修改手机号
    public static final String PHONE_NOT_EMPTY = "手机号不能为空！"; 
    public static final String PHONE_FORMAT_INCORRECT = "手机号格式不正确！"; 
    public static final String PHONE_EXIST = "手机号已存在！"; 

    
    //修改登录名
    public static final String ACCOUNT_NOT_EMPTY = "登录用户名不能为空！"; 
    public static final String ACCOUNT_REGULAR_EXPRESSION  = "登录账号只能是数字+字母组合6-10位！"; 
    public static final String ACCOUNT_EXIST = "登录用户名已存在！"; 
}
