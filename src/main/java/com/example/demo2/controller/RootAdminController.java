package com.example.demo2.controller;

import com.example.demo2.common.ServerResponse;
import com.example.demo2.service.impl.RootAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author yangshaojun
 * @ClassName UserController
 * @Description
 * @create 2018-12-24 上午 10:14
 * @Version 1.0
 **/

@Controller
@RequestMapping("/api/back/admin")
public class RootAdminController {


    @Autowired
    private RootAdminServiceImpl rootAdminService;

    /**
     * 功能描述: 管理员登录
     *
     * @MethodName valid_code
     * @param: [user, mobileCode]
     * @return: com.araya.asset.common.ServerResponse<java.lang.String>
     * @auther: yangshaojun
     * @date: 2018/9/8 下午8:52
     */
    @ResponseBody
    @RequestMapping("/login")
    public ServerResponse<HashMap<String, String>> login(String username, String password, String mobileCode) {


        return rootAdminService.login(username, password, mobileCode);


    }

//    @ResponseBody
//    @RequestMapping("/test")
//    public ServerResponse<String> test() throws IOException {
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        User user = new User();
//        user.setMobile("123");
//        String json = mapper.writeValueAsString(user);
//
//        String json = JsonUtil.objToString(user);
//        System.out.println(json);
//        byte[] bytes1 = AESUtil.encrypt(json).getBytes("UTF-8");
//
//        return ServerResponse.createBySuccess(AESUtil.encrypt(json));
//
//    }
//
//
//            byte[] 你好s = AESUtil.desEncrypt("你好").getBytes("UTF-8");
//        System.out.println(你好s);


//    public static void main(String[] args) throws IOException {

//        ObjectMapper mapper = new ObjectMapper();
//        User user = new User();
//        user.setMobile("123");
//        String s = JsonUtil.objToString(user);
//        System.out.println(s);
//        String json = mapper.writeValueAsString(user);
//        byte[] bytes1 = AESUtil.encrypt(s).getBytes("UTF-8");

//        System.out.println(AESUtil.encrypt(s));
//    }

}
