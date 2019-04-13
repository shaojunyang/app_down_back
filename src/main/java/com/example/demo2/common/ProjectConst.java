package com.example.demo2.common;

/**
 * @author yangshaojun
 * @ClassName ProjectConst
 * @Description
 * @create 2018-09-12 下午 18:09
 * @Version 1.0
 **/
/**
 * @author scw
 * @create 2018-01-18 15:31
 * @desc 项目相关的静态量
 **/
public class ProjectConst {
    /**
     * 用于获取当前与微信公众号交互的用户信息的接口（一般是用第一个接口地址）
     */
    public static final String GET_WEIXIN_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
    public final static String GetPageUsersUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 用于进行网页授权验证的接口URL，通过这个才可以得到opendID等字段信息
     */
    public final static String GET_WEBAUTH_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 用于进行当点击按钮的时候，能够在网页授权之后获取到code，再跳转到自己设定的一个URL路径上的接口，这个主要是为了获取之后于
     * 获取openId的接口相结合
     * 注意：参数：toselfURL  表示的是当授权成功后，跳转到的自己设定的页面，所以这个要根据自己的需要进行修改
     */
    public final static String Get_WEIXINPAGE_Code = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=toselfURL&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";


    // appid  和 appsecret
    public static final String PROJECT_APPID = "wxfa4654c36c428e67" ;
    public static final String PROJECT_APPSECRET = "50c01b6992518d90d5028908a952c3c3";
    /**
     * 获取access_token的URL
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

}
