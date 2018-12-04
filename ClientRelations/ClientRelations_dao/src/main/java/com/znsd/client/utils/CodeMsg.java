package com.znsd.client.utils;

/** 
 * CodeMsg 用于保存 异常码和异常信息，由于都是失败没有数据返回
*/
public class CodeMsg {
	private int code;
	private String msg;
	/**通过静态方法调用CodeMsg对象获取对应error信息 自定义error 信息
     * */

    /*登陆异常 5002xx*/
    public static CodeMsg LOGIN_ERROR_PASSWORD_EMPTY = new CodeMsg(500201,"密码不能为空");
    public static CodeMsg LOGIN_ERROR_MOBILE_EMPTY = new CodeMsg(500202,"手机号不能为空");
    public static CodeMsg LOGIN_ERROR_MOBILE_ERROR = new CodeMsg(500203,"手机号格式错误");
    public static CodeMsg LOGIN_ERROR_USER_NOT_ERROR = new CodeMsg(500203,"手机不存在");
    public static CodeMsg LOGIN_ERROR_PASS_ERROR = new CodeMsg(500203,"密码错误");

    /*私有化构造函数
    * 并且使得所有set 方法失效，接口健壮性*/
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /** 该方法用于返回一个CodeMsg对象 便于 全局异常处理的调用
     *  全局异常处理传入 objects 参数，并返回一个CodeMsg 对象
     *  该方法根据入参 显示 对应的异常code , 以及加入 异常信息的msg显示
     * */
    /*利用可变长参数定义 ：适用于 参数类型可知，但是个数未知的情况 */
    public CodeMsg fillArgs(Object...objects){
        int code = this.code; /* */
        String message = String.format(this.msg,objects);
        return new CodeMsg(code,message);
    }
}
