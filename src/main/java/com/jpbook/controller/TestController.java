package com.jpbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("{name}")
    public void test(){}

    @RequestMapping("back/{name}")
    public void test2(){}

}
