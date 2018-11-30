package com.znsd.client.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092200568015";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxVAAC+s/eUy+fUI87e/7Vbf5P5OGf2qR/vS6LPJ/npCtTP9c/Qsc8kHvA7ebKsKyjuVNWRX/kULxWscSi/6n3ATnQGBYyvUIle68zBaKyeRGdAzbzDhKULBUDrzwrKhg/3HVj7j6W/JYmS5sMzvWcngbVF23a3hpnJOKUt6td4ldlng9zJL0+FowbMPESKnWXqSQcORCNq5E/qBjj4GWbfYXGyJbEN6nh+E5671RFSi+lg1ml2i9oFM4h2Wa+qnL5+MgH41D8BXmP8/Djqy+sjfJ1JobVKpDLHVMcxszq0mSob7shnL0jhLVtV+o+Xdnydr3aIFyYJ1cm8KiLwXPJAgMBAAECggEAGvXWep1/dSHYn7Qz0qtrdy+d9q+pzhAD6pfst6aj+SfwnluacjfI6uBcsFx7Nl3eIZZPoVI3u5K6z8N/Tfjo8nDxRT4kQdqcb+56GJvGvLPDhcezVwjQsk5xc3n0/+sKfMsb3fGe+n20pmXgUPY2SXWNPGCvhxM1mHD3Mf0qxL8fvD60/9AaKpa6WS9xLgoWOHFYjCY7EmdSNdsdI1y1xN1832vHUpeCEatP6dyNxJRfzbdpHH24gBDy1EQ+9DBgy8YoVRhg8R+5NqQCFfbkO1atsJ0t5CHhIm4IMUmscP6HXo8Opmbz905nH1icFzYabqO4yI0BrK1iw9Q+5TPiAQKBgQDszZ+ha2l3VUm4tKu6hiM9VwozsN12uFRktvXIfvj9Y5kLqBtD9KVZQLHSpKLLKx/Ds6seSNae2H7KHwd/PVA6EGdgPyIdMOuwavz0hh0oaEdqPs2qfjiPtdX8C3kt3sqKuMj1K9dKwtuF5Ir2x2WFJlmsNS2lwB7cgPRh/mfzeQKBgQC/tBcQCKDPcwCzVqXVSdz5f2yowBJYjuGxLgT3iYuavZ2FZrO6PUHUP4Fu26GJLQU1hpKvzeKnH9Z7FxbiDBvrHJGbs8V3YJ0rIE8Kfzz9PZ+bcs4Oj3mGeHkdvUrNU+Sx0/GpWj03Og+wDf9SomKn60zfLWFxbk6VIb70Ztee0QKBgA8xnlVwG+NBQKquRPqB0s8Dv67TYVJVv2x65MhJhVZUxqQd1CoHD3jrkr1OPPfGO5KF+6vExqiIgZIcbZG3cGdZWBiv1FOFKQo3wyU5WbOXBUYG45FV6fEmnKVAYzUTP3GpK5O3jWfJmuY7ZMMyxgvGCyjmfJhO/Gvvhj6nYSoZAoGAPlBU2tJjK2uvg5wbxav/114TPPtKO10egdB6rtgX+BHAvVc3/sbguhR2h0l/Ra7Lra1zyw+6qCaSOmqz9oCHJrKfpiQWgQp3rEgRSVE4yvyYABieYF9E2nAYtpEMWpf1k9RYDnuVwHjwFoNGRl8ggILc9wKyVQPNKW7RunIfjrECgYEAwv8dRgx4OH4FSo7vKFxYYGsQeuxF6qaBV2jDWcCvVMxGPCeLgzT2izJFKHXndVqFeT25i84Uk4Qdj8LxdI7q+WiZYDdPdt9JZkam92jQFzXqyMmZvBB5YtxT9yQRiWmXlewCf6qm9yJwupIsmXvAnQQH1aqSjUlBPA48fGd8d6o=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr7o/37sVxM+a6j2DkfKKJf7amjRi5A6uQfbCUJuu9yDRNu0julPJpZblFeygSpKV3Nis/yG9WR4MeKOVbwlFIJu6DHfEMak4pBZ3QXkirMusaeGTaPmRJIBR/IRnTg248NppDKKKI+PVX5xve40IuIfpctRpxkwSLBvGdg7xXUMpSml0cy3w8ElNYx1FQWF3nSo4fxy7ReTj3X7ILk7D1sujqOMZjpbczAdPjZvdmKwdglLSqsZXs2gUED0c8VEYixk6ame30DQKLZE+jd2HtuLyXrvItUM8T2HsbrQi/lrxiw7l89uHkVH64fShrZPE/nLPDVIBaIfbo/6Rv0kOQQIDAQAB";

	// 服务器异步通知页面路径	(对账操作)
	public static String notify_url = "http://aaabbbcccdddd.gnway.cc:8000/ClientRelations_action/notifyUrl";
 
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://aaabbbcccdddd.gnway.cc:8000/ClientRelations_action/admin/views/orderManager/changeHands.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关(API 请求地址)
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

