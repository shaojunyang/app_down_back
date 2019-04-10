package com.example.demo2.controller;

import com.example.demo2.en.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangshaojun
 * @ClassName AController
 * @Description
 * @create 2019-04-10 上午 9:47
 * @Version 1.0
 **/

@Controller
public class AController {


    @RequestMapping(value = "/aaa")
    @ResponseBody
    public Menu menu() {

        return new Menu();
    }

    @RequestMapping(value = "/bbb")
    @ResponseBody
    public List<Menu> list() {
        return null;

    }
}
