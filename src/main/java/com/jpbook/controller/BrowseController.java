package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("browse")
public class BrowseController {
    @Autowired
    BrowseService bs;
    @RequestMapping("getChapidByUUid")
    @ResponseBody
    public Integer getChapidByUUid(Integer bookid,HttpSession session){
        System.out.println(bookid);
        List<Users> users = (List<Users>)session.getAttribute("users");
        if(users==null){
            return -1;
        }
        List<Map<String, Object>> chapidByUUid = bs.getChapidByUUid(users.get(0).getUuid(),bookid);
        return Integer.parseInt(chapidByUUid.get(0).get("chapid").toString());
    }
}
