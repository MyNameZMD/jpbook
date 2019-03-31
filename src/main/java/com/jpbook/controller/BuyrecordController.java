package com.jpbook.controller;

import com.jpbook.entity.Layui;
import com.jpbook.entity.Users;
import com.jpbook.service.BuyrecordService;
import com.jpbook.service.ChapterService;
import com.jpbook.service.UsersService;
import org.omg.PortableInterceptor.INACTIVE;
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
    @Autowired
    UsersService us;
    @Autowired
    ChapterService cs;
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
    @RequestMapping("buyrecordChap")
    @ResponseBody
    public Integer buyrecordChap(Integer[] chapid,Integer money,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Integer num=0;
        for (Integer c :
                chapid) {
            num+=bs.buyrecordChap(c,users1.get(0).getUuid());
        }
        us.rewardNew(users1.get(0).getUuid(),money);
        return num;
    }
    @RequestMapping("getUnpurchasedGoodwillMethodByUuid")
    @ResponseBody
    public Integer getUnpurchasedGoodwillMethodByUuid(Integer bookid,Integer money,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Integer[] chapid=bs.getUnpurchasedGoodwillMethodByUuid(bookid,users1.get(0).getUuid());
        Integer num=0;
        for (Integer c :
                chapid) {
            num+=bs.buyrecordChap(c,users1.get(0).getUuid());
        }
        us.rewardNew(users1.get(0).getUuid(),money);
        return num;
    }
    @RequestMapping("getByChapidAndUuid")
    @ResponseBody
    public Integer getByChapidAndUuid(Integer chapid,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Integer uuid=-1;
        if (users1!=null){
            uuid=users1.get(0).getUuid();
        }
        List<Map<String, Object>> byChapidAndUuid = bs.getByChapidAndUuid(chapid, uuid);
        Integer money=0;
        if (byChapidAndUuid.size()==0){
            money=cs.getChapMoney(chapid);
        }
        return money;
    }
}
