package com.jpbook.controller;

import com.jpbook.entity.Layui;
import com.jpbook.entity.Users;
import com.jpbook.service.BuyrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("buyrecord")
public class BuyrecordController {
    @Autowired
    BuyrecordService bs;
    @RequestMapping("queryStatistics")
    @ResponseBody
    public Map<String,Object> queryStatistics(Integer bookid, HttpSession session){
        //之后uuid从session中得到
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Map<String, Object> stringObjectMap = bs.queryStatistics(users1.get(0).getUuid(), bookid);
        System.out.println("stringObjectMap:"+stringObjectMap);

        return stringObjectMap;
    }
    @RequestMapping("getStatistics")
    @ResponseBody
    public Layui getStatistics(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        List<Map<String, Object>> statistics = bs.getStatistics(users1.get(0).getUuid());
        Layui layui=new Layui();
        layui.setData(statistics);
        System.out.println(layui);
        return layui;
    }
}
