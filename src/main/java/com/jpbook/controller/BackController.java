package com.jpbook.controller;

import com.jpbook.entity.Emp;
import com.jpbook.entity.BackChart;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Lp;
import com.jpbook.service.BackService;
import com.jpbook.util.Gs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("back")
public class BackController {

    @Resource
    BackService bs;

    @RequestMapping("novelquery")
    public LayuiPage novelquery(LayuiPage lp){
        return bs.novelquery(lp);
    }

    @RequestMapping("userquery")
    public LayuiPage userquery(LayuiPage lp){
      return bs.userquery(lp);
    }

    @RequestMapping("authorquery")
    public LayuiPage authorquery(LayuiPage lp){
        return bs.authorquery(lp);
    }

    @RequestMapping("booksincome")
    public Lp booksincome(){
        return bs.booksincome();
    }

    @RequestMapping("deal")
    public Map<String,Object> deal(){
        return bs.deal();
    }

    @RequestMapping("thismonth")
    public Lp thismonth(){
       return bs.thismonth();
    }
    @RequestMapping("getAllIncome")
    public Object[] getAllIncome(){ return bs.getAllIncome();}
    @RequestMapping("getAllAndYear")
    public Map<String,Object> getAllAndYear(){return bs.getAllAndYear();}
    @RequestMapping("getAllAuthorMoney")
    public LayuiPage getAllAuthorMoney(LayuiPage lp){return bs.getAllAuthorMoney(lp);}
    @RequestMapping("getAllAuthorDistribute")
    public List<Map<String,Object>> getAllAuthorDistribute(){return bs.getAllAuthorDistribute();}
    @RequestMapping("getUsersAndAuthorCount")
    public Map<String,Object> getUsersAndAuthorCount(){return bs.getUsersAndAuthorCount();}
    @RequestMapping("getBookTypeProportion")
    public List<Map<String,Object>> getBookTypeProportion(){return bs.getBookTypeProportion();}
    @RequestMapping("getAllCountByBtid")
    public LayuiPage getAllCountByBtid(LayuiPage lp){return bs.getAllCountByBtid(lp);}

    @RequestMapping("adminquery")
    public Map<String,Object> admin_info(HttpSession session){
        return bs.admin_info(Gs.geteid(session));
    }

    @RequestMapping("eidtadmin")
    public Integer eidtadmin(Emp emp,HttpSession session){
        emp.setEid(Gs.geteid(session));
        return bs.eidtadmin(emp);
    }

    @RequestMapping("getpwd")
    public Integer getpwd(String pwd,String epwd,HttpSession session){
        if (!bs.getpwd(Gs.geteid(session)).equals(pwd)){
            return 0;
        }else {
            bs.editpwd(epwd,Gs.geteid(session));
        }
        return 1;
    }

}

