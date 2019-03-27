package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.entity.Vote;
import com.jpbook.service.VoteService;
import com.jpbook.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("vote")
public class VoteController {
    @Autowired
    VoteService vs;
    @Autowired
    WalletService ws;
    @RequestMapping("voteMonth")
    @ResponseBody
    public Integer voteMonth(Vote vote, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        vote.setUuid(users1.get(0).getUuid());
        ws.voteMonth(vote.getVotenum(),users1.get(0).getUuid());
        return vs.voteMonth(vote);
    }
    @RequestMapping("voteRec")
    @ResponseBody
    public Integer voteRec(Vote vote, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        vote.setUuid(users1.get(0).getUuid());
        ws.voteRec(vote.getVotenum(),users1.get(0).getUuid());
        return vs.voteRec(vote);
    }
}
