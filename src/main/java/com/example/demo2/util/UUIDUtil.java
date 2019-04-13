package com.example.demo2.util;

import java.util.UUID;

/**
 * @author yangshaojun
 * @ClassName UUIDUtil
 * @Description
 * @create 2018-08-22 上午 9:49
 * @Version 1.0
 **/

public class UUIDUtil {
      public static String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + UUID.randomUUID().toString());
        System.out.println("格式化后的UUID ：" + getUUID());
    }
}
