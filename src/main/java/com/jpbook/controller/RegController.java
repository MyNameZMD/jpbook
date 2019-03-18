package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.LoginService;
import com.jpbook.service.RegService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("reg")
public class RegController {

    @Resource
    RegService rs;

    @Resource
    LoginService ls;

    @RequestMapping("queryPhone")
    @ResponseBody
    public Integer queryPhone(String phone){
        return rs.queryPhone(phone);
    }

    @RequestMapping("yzm")
    @ResponseBody
    public String yzm(String phone){
        return ls.phongMessage(phone);
    }


}
