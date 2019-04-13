package com.example.demo2.common;

/**
 * @author yangshaojun
 * @ClassName APIConst
 * @Description
 * @create 2018-10-23 上午 11:59
 * @Version 1.0
 **/

public class APIConst {

    // 钉钉请求 api host
    public static String DING_DING_HOST = "https://oapi.dingtalk.com";
    public static String DING_DING_GET_ACCESS_TOEKN_PATH = "/gettoken";
    public static String DING_DING_GET_DEPARTMENT_LIST_PATH = "/department/list";
    public static String DING_DING_GET_USER_LIST_PATH = "/user/list";

    // 企业微信请求 api host
    public static String BUSINESS_WEIXIN_HOST = "https://qyapi.weixin.qq.com";
    public static String BUSINESS_WEIXIN_GET_ACCESS_TOEKN_PATH = "/cgi-bin/gettoken";
    public static String BUSINESS_WEIXIN_GET_DEPARTMENT_LIST_PATH = "/cgi-bin/department/list";
    public static String BUSINESS_WEIXIN_GET_USER_LIST_PATH = "/cgi-bin/user/list";
}
