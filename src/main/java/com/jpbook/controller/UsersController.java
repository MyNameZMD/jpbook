package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersService us;
    @RequestMapping("getRemuneration")
    @ResponseBody
    public List<Map<String,Object>> getRemuneration(Integer year,Integer month,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        String startTime=year+"-"+month+"-1";
        String endTime=year+"-"+(month+1)+"-1";
        return  us.getRemuneration(startTime,endTime,users1.get(0).getUuid());
    }
    @RequestMapping("openwriter")
    public String openwriter(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if(users1==null){
            return "redirect:/login";
        }
        String pen = users1.get(0).getPen();
        if("".equals(pen)||pen==null){
            return "writerperfect";
        }else{
            return "redirect:/authorWorks";
        }
    }
    @RequestMapping("upWriter")
    @ResponseBody
    public Integer upWriter(Users users, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        System.out.println(users1);
        System.out.println(users);
        users.setUuid(users1.get(0).getUuid());
        us.upWriter(users);
        users1.get(0).setPen(users.getPen());
        if (users.getSex()!=null){
            users1.get(0).setSex(users.getSex());

        }else {
            users.setSex(users1.get(0).getSex());
        }
        users1.get(0).setEmail(users.getEmail());
        users1.get(0).setQqid(users.getQqid());
        users1.get(0).setPro(users.getPro());
        users1.get(0).setCity(users.getCity());
        users1.get(0).setRealname(users.getRealname());
        users1.get(0).setIdcard(users.getIdcard());
        session.setAttribute("users",users1);
        return 1;
    }
    @RequestMapping("getUsersByPen")
    @ResponseBody
    public boolean getUsersByPen(String pen,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        System.out.println("pen:"+pen);
        Users usersByPen = us.getUsersByPen(pen);
        System.out.println("usersByPen："+usersByPen);
        if (usersByPen==null||users1.get(0).getPen().equals(pen)){
            return true;
        }else{
            return false;
        }

    }
    @RequestMapping("withdraw")
    @ResponseBody
    public Integer withdraw(Double money,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Integer withdraw = us.withdraw(money, users1.get(0).getUuid());
        users1.get(0).setWithdrawmoney(users1.get(0).getWithdrawmoney()+money);
        session.setAttribute("users",users1);
        return withdraw;
    }
    @RequestMapping("getNewMoney")
    @ResponseBody
    public Integer getNewMoney(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        return us.getNewMoney(users1.get(0).getUuid());
    }
    @RequestMapping("ckSession")
    @ResponseBody
    public Integer ckSession(HttpSession session,String name){
        Object attribute = session.getAttribute(name);
        System.out.println(name);
        System.out.println(attribute);
        return attribute==null?0:1;
    }
    @RequestMapping("getSummoenyAndWithdrawmoney")
    @ResponseBody
    public Map<String,Object> getSummoenyAndWithdrawmoney(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        return us.getSummoenyAndWithdrawmoney(users1.get(0).getUuid());
    }

}
