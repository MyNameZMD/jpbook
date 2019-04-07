package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.LoginService;
import com.jpbook.service.RegService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public String yzm(String phone, HttpSession session){
        session.setAttribute("yzm",ls.phongMessage(phone));
        session.setMaxInactiveInterval(60*2);
        return "1231";
    }


}
