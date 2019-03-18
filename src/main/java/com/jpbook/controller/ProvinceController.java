package com.jpbook.controller;

import com.jpbook.service.ProvinceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("province")
public class ProvinceController {
    @Resource
    ProvinceService ps;

    @RequestMapping("queryAll")
    public String queryAll(Model m){
        m.addAttribute("list",ps.queryAll());
        return "test";
    }
}
