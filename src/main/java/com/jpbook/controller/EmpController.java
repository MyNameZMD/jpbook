package com.jpbook.controller;

import com.jpbook.entity.Emp;
import com.jpbook.service.BackService;
import com.jpbook.service.EmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Emp")
public class EmpController {

    @Autowired
    EmpService es;

    @RequestMapping("login")
    @ResponseBody
    public Integer login(String ename,String epwd,HttpSession session) {

        Emp login = es.Hlogin(ename, epwd);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("","","");
        if (null != login) {
           token = new UsernamePasswordToken(ename,epwd,"");
           session.setAttribute("emp",login);
        }
        try {
            subject.login(token);
            return 0;
        }catch (UnknownAccountException e){
            //用户不存在
            return 1;
        }catch (IncorrectCredentialsException e){
            //密码错误
            return 2;
        }

    }

    @RequestMapping("quit")
    @ResponseBody
    public Integer quit(){
        Subject subject=SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return 1;
    }


}
