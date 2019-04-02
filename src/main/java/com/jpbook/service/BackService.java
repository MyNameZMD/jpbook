package com.jpbook.service;

import com.jpbook.dao.BackDao;
import com.jpbook.entity.BackChart;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Lp;
import com.jpbook.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    public Object[] getAllIncome(){
        Object[] backCharts=new Object[3];
        Integer[] allIncome = bd.getAllIncome();
        BackChart backChart=new BackChart();
        backChart.setName("所有收入");
        backChart.setType("bar");
        backChart.setData(allIncome);
        backCharts[0]=backChart.toString();
        Integer[] allBuyrecord = bd.getAllBuyrecord();
        backChart=new BackChart();
        backChart.setName("订阅收入");
        backChart.setType("bar");
        backChart.setData(allBuyrecord);
        backCharts[1]=backChart.toString();
        Integer[] allReward = bd.getAllReward();
        backChart=new BackChart();
        backChart.setName("打赏收入");
        backChart.setType("bar");
        backChart.setData(allReward);
        backCharts[2]=backChart.toString();
        return backCharts;
    }
    public Map<String,Object> getAllAndYear(){return bd.getAllAndYear();}
    public LayuiPage getAllAuthorMoney(LayuiPage lp){
        lp.setCount(bd.count("users where pen !=''"));
        lp.setData(bd.authorquery(lp));
        System.out.println(lp);
        lp.setData(bd.getAllAuthorMoney());
        return lp;
    }
    public List<Map<String,Object>> getAllAuthorDistribute(){return bd.getAllAuthorDistribute();}
    public Map<String,Object> getUsersAndAuthorCount(){return bd.getUsersAndAuthorCount();}
    public List<Map<String,Object>> getBookTypeProportion(){return bd.getBookTypeProportion();}
    public LayuiPage getAllCountByBtid(LayuiPage lp){
        lp.setCount(14);
        lp.setData(bd.getAllCountByBtid());
        return lp;
    }
}
