package com.jpbook.controller;

import com.jpbook.entity.Rbreply;
import com.jpbook.entity.Users;
import com.jpbook.service.RbreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("rbreply")
public class RbreplyController {
    @Autowired
    RbreplyService rs;

    @RequestMapping("add")
    @ResponseBody
    public Map<String,Object> add(Rbreply rp, Integer bookid, HttpSession session){
        /*redirect:/reviewbook/queryById?bookid="+bookid+"&revid="+rp.getRevid()*/
        if(rp.getFrom_uuid() == null){
            List<Users> users = (List<Users>)session.getAttribute("users");
            if(null != users){
                rp.setFrom_uuid(users.get(0).getUuid());
            }
        }
        Map<String,Object> map = new HashMap<String,Object>();
        rs.add(rp);
        map.put("rp",rp);
        return map;
    }
    /*"redirect/queryNewRbreply?replytype="+rp.getReplytype()+"&from_uuid+"rp.getFrom_uuid();*/
    @RequestMapping("queryNewRbreply")
    @ResponseBody
    public List<Map<String,Object>> queryNewRbreply(Integer replytype,Integer from_uuid){
        return rs.queryNewRbreply(replytype,from_uuid);
    }
    @RequestMapping("queryRbRbreply")
    @ResponseBody
    public List<Map<String,Object>> queryRbRbreply(Integer revid){
        return rs.queryRbRbreply(revid);
    }
}
