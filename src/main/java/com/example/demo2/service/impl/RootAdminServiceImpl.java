package com.example.demo2.service.impl;


import com.example.demo2.common.ServerResponse;
import com.example.demo2.dao.RootAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author yangshaojun
 * @ClassName CompanyServiceImpl
 * @Description
 * @create 2018-10-25 下午 17:12
 * @Version 1.0
 **/

@Service
public class RootAdminServiceImpl {

    @Autowired
    private RootAdminMapper rootAdminMapper;


    public ServerResponse<HashMap<String, String>> login(String mobile, String password, String mobileCode) {

        if (mobileCode == null || mobile == null || password == null) {
            return ServerResponse.createByErrorMessage("参数错误,请填写完整参数");
        }
        // 查询该管理员是否存在
        Integer count = rootAdminMapper.countByMobileAndPassword(mobile, password);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }


        // 毫秒
        // 设置为1000
        //给用户jwt加密生成token  这里是关键，生成了token 后，怎么给前台返回，那可以用你自己的方法；
//        String token = JWT.sign(mobile, 60L * 1000L * 60L * 24L);
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("token", token);
//        map.put("mobile", mobile);

        // 验证码如果是手机号后6位也可以登录，方便测试
        if (mobileCode.equals(mobile.substring(mobile.length() - 6))) {
            return ServerResponse.createBySuccessMessage("登录成功");
        }


        // 从缓存中获取验证码
//        String code = RedisPoolUtil.get(mobile + Const.MOBILE_CODE_PREFIX);

        // 效验验证码
//        if (!mobileCode.equals(code)) {
//            return ServerResponse.createByErrorMessage("验证码填写错误");
//        }
        return ServerResponse.createBySuccessMessage("登录成功");

    }


    public static void main(String[] args) {
        System.out.println(60L * 1000L * 30L);
    }
}
