package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.LoginService;
import com.jpbook.service.RegService;
import com.jpbook.util.DateUtil;
import com.jpbook.util.Gs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService ls;

    @Resource
    RegService re;

    @RequestMapping("landing")
    @ResponseBody
    public Integer login(String username,String password,String phone,String pwd,Users u,String yzm,HttpSession session){

        Integer rs = 0;
       if (null != username && null != password){
           List<Users> list =  ls.landing(username,password,username,password);
           session.setAttribute("users",list);
           if (list.size() > 0){
               rs = 1;
           }
       }
       if (null != phone && pwd == null){
           List<Users> list = ls.userInfo(phone);
           if (yzm.equals(session.getAttribute("yzm"))){
               if (list.size() > 0){
                   session.setAttribute("users",list);
                   rs = 2;
               }else {
                   u.setPhone(phone);
                   ls.addUser(u);
                   re.def1(re.seluser(u.getPhone()));
                   re.def2(re.seluser(u.getPhone()));
                   session.setAttribute("users",ls.userInfo(phone));
                   rs = 2;
               }
           }else {
               rs = -1;
           }
       }
       if(null != u.getPhone() && null != u.getPwd()){
           if (yzm.equals(session.getAttribute("yzm"))){
               re.adduser(u);
               re.def1(re.seluser(u.getPhone()));
               re.def2(re.seluser(u.getPhone()));
               session.setAttribute("users",ls.userInfo(u.getPhone()));
               rs = 3;
           }else {
               rs = -1;
           }
       }

       session.setAttribute("newdate",new Date());

       //赠送推荐票
        List<Users> usergrade = (List<Users>)session.getAttribute("users");
        if(null != usergrade && usergrade.size() > 0){
            if(usergrade.get(0).getGrade() >=3 && usergrade.get(0).getGrade() < 13){
                ls.editwallet(1,usergrade.get(0).getUuid());
            }else if(usergrade.get(0).getGrade() >=13 && usergrade.get(0).getGrade() < 23){
                ls.editwallet(2,usergrade.get(0).getUuid());
            }else if(usergrade.get(0).getGrade() >=23){
                ls.editwallet(3,usergrade.get(0).getUuid());
            }
        }

       return rs;
    }

    //获取验证码
    @RequestMapping("phoneLogin")
    @ResponseBody
    public Integer phoneLogin(String phone,HttpSession session){
        session.setAttribute("yzm",ls.phongMessage(phone));
        session.setMaxInactiveInterval(60*2);
        return 1;
    }

    @RequestMapping("emptySession")
    public String emptySession(HttpSession session) {
        Long second = DateUtil.getSubSecond(new Date(),(Date)session.getAttribute("newdate"));
        ls.editsignlong(second.intValue(), Gs.getsession(session));
        session.removeAttribute("users");
        return "redirect:/login";
    }
    @RequestMapping("quit")
    @ResponseBody
    public Integer quit(HttpSession session){
        Long second = DateUtil.getSubSecond(new Date(),(Date)session.getAttribute("newdate"));
        ls.editsignlong(second.intValue(), Gs.getsession(session));
        session.removeAttribute("users");
        return 1;
    }
}
