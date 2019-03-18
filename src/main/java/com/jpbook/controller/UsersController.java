package com.jpbook.controller;

import com.jpbook.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersService us;
    @RequestMapping("getRemuneration")
    @ResponseBody
    public List<Map<String,Object>> getRemuneration(Integer year,Integer month){
        String startTime=year+"-"+month+"-1";
        String endTime=year+"-"+(month+1)+"-1";
        return  us.getRemuneration(startTime,endTime,10000);
    }
}
