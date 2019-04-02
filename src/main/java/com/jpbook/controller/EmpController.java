package com.jpbook.controller;

import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("Emp")
public class EmpController {

    @Autowired
    EmpService es;

    @RequestMapping("login")
    @ResponseBody
    public Integer login(String ename,String epwd) {

        Emp login = es.Hlogin(ename, epwd);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("","","");
        if (null != login) {
           token = new UsernamePasswordToken(ename,epwd,"");
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
    @RequestMapping("getAllEmp")
    @ResponseBody
    public LayuiPage getAllEmp(LayuiPage lp){return es.getAllEmp(lp);}
    @RequestMapping("empDimission")
    @ResponseBody
    public Integer empDimission(Integer eid){return es.empDimission(eid);}
    @RequestMapping("empResume")
    @ResponseBody
    public Integer empResume(Integer eid){return es.empResume(eid);}
    @RequestMapping("addEmp")
    @ResponseBody
    public Integer addEmp(Emp emp){
        System.out.println(emp);
        return es.addEmp(emp);
    }

}
