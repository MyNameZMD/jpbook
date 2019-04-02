package com.jpbook.service;

import com.jpbook.dao.BackDao;
import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Lp;
import com.jpbook.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackService {

    @Resource
    BackDao bd;

    public LayuiPage novelquery(LayuiPage lp){
        if(lp.getSearchContent() != null){
            lp.setCount(bd.novelCount(lp.getSearchContent()));
        }else {
            String tableName = "books";
            lp.setCount(bd.count(tableName));
        }
        lp.setData(bd.novelquery(lp));
        return lp;
    }

    public LayuiPage userquery(LayuiPage lp){
        String tableName = "users";
        lp.setCount(bd.count(tableName));
        lp.setData(bd.userquery(lp));
        return lp;
    }

    public LayuiPage authorquery(LayuiPage lp){
        String tableName = "(select distinct u.uuid from users u,books b where u.uuid=b.uuid and pen!='') num";
        lp.setCount(bd.count(tableName));
        lp.setData(bd.authorquery(lp));
        System.out.println(lp);
        return lp;
    }

    public Lp booksincome(){
        Lp lp = new Lp();
        lp.setTotal(bd.booksincome().size());
        Map map = new HashMap();
        map.put("item",bd.booksincome());
        lp.setRows(map);
        return lp;
    }

    public List<Map<String,Object>> homepage(){
        return bd.homepage();
    }

    public Map<String,Object> deal(){
        return bd.deal();
    }

    public Lp thismonth(){
        Lp lp = new Lp();
        String month = DateUtil.getYear(new Date())+"-"+DateUtil.getMonth(new Date());
        lp.setTotal(bd.thismonth(month).size());
        Map map = new HashMap();
        map.put("item",bd.thismonth(month));
        lp.setRows(map);
        return lp;
    }

    public Map<String,Object> admin_info(Integer eid){
        return bd.admin_info(eid);
    }

    public Integer eidtadmin(Emp emp){
        return bd.eidtadmin(emp);
    }

    public String getpwd(Integer eid){
        return bd.getpwd(eid);
    }

    public Integer editpwd(String epwd,Integer eid){
        return bd.editpwd(epwd,eid);
    }

}
