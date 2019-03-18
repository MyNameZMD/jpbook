package com.jpbook.controller;

import com.jpbook.entity.Layui;
import com.jpbook.service.BuyrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("buyrecord")
public class BuyrecordController {
    @Autowired
    BuyrecordService bs;
    @RequestMapping("queryStatistics")
    @ResponseBody
    public Map<String,Object> queryStatistics(Integer bookid){
        //之后uuid从session中得到
        Map<String, Object> stringObjectMap = bs.queryStatistics(10000, bookid);
        System.out.println("stringObjectMap:"+stringObjectMap);

        return stringObjectMap;
    }
    @RequestMapping("getStatistics")
    @ResponseBody
    public Layui getStatistics(){
        List<Map<String, Object>> statistics = bs.getStatistics(10000);
        Layui layui=new Layui();
        layui.setData(statistics);
        System.out.println(layui);
        return layui;
    }
}
