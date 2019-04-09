package com.jpbook.controller;

import com.jpbook.entity.Reward;
import com.jpbook.entity.Users;
import com.jpbook.entity.Vote;
import com.jpbook.service.RewardService;
import com.jpbook.service.UsersService;
import com.jpbook.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("reward")
public class RewardController {
    @Autowired
    RewardService rs;
    @Autowired
    UsersService us;
    @Autowired
    WalletService ws;
    @RequestMapping("getReward")
    @ResponseBody
    public List<Map<String,Object>> getReward(Integer year, Integer month, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        String startTime=year+"-"+month+"-1";
        String endTime=year+"-"+(month+1)+"-1";
        return rs.getReward(users1.get(0).getUuid(),startTime,endTime);
    }

    @RequestMapping("rewardNew")
    @ResponseBody
    public Integer rewardNew(Reward reward, HttpSession session) {
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        reward.setUuid(users1.get(0).getUuid());
        if (reward.getRewanum()>=1000){
            ws.giveMonth(reward.getRewanum()/10000,users1.get(0).getUuid());
        }
        us.rewardNew(users1.get(0).getUuid(),reward.getRewanum());
        return rs.rewardNew(reward);
    }
}
