package com.jpbook.controller;

import com.jpbook.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("reward")
public class RewardController {
    @Autowired
    RewardService rs;
    @RequestMapping("getReward")
    @ResponseBody
    public List<Map<String,Object>> getReward(Integer year,Integer month){
        String startTime=year+"-"+month+"-1";
        String endTime=year+"-"+(month+1)+"-1";
        return rs.getReward(10000,startTime,endTime);
    }
}
