package com.example.demo2.controller;

import com.example.demo2.dao.MenuMapper;
import com.example.demo2.en.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangshaojun
 * @ClassName HelloWorldController
 * @Description
 * @create 2019-04-10 上午 10:06
 * @Version 1.0
 **/

@RestController
public class HelloWorldController {
    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/hello")
    public List<Menu> index() {
        List<Menu> menus = menuMapper.find();
        return menus;
//        return new Menu();
    }
}
