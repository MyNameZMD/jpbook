package com.jpbook.controller;

import com.jpbook.service.PersonageService;
import com.jpbook.util.Gs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("pc")
public class PersonageController {
    @Resource
    PersonageService ps;

    @RequestMapping("authorData")
    public String authorData(Integer bid, Model model, HttpSession session){
        model.addAttribute("author",ps.authorData(bid));      //作者id
        model.addAttribute("hot",ps.hotSerial(bid, Gs.getsession(session)));    //作者id   用户id
        model.addAttribute("list",ps.authorBooks(bid,Gs.getsession(session))); //作者id   用户id
        return "author_details.html";
    }

    @RequestMapping("home")
    public String homepage(Integer uuid,Model model,HttpSession session){
        model.addAttribute("h",ps.homeInfo(uuid));   //作者id ...
        model.addAttribute("q1",ps.q1(uuid));
        model.addAttribute("q2",ps.q2(uuid));
        model.addAttribute("q3",ps.q3(uuid));        //作者id

        model.addAttribute("fansState",ps.fansState(uuid,Gs.getsession(session)));

        model.addAttribute("userbooks",ps.usersBooks(uuid,Gs.getsession(session)));

        return "homepage.html";
    }

    @RequestMapping("fansAdd")
    @ResponseBody
    public Integer addfans(Integer buuid,HttpSession session){
        Integer getsession = Gs.getsession(session);
        if (null == getsession){
            return -1;
        }else {
            ps.fansAdd(getsession,buuid);
        }
        return 1;
    }

    @RequestMapping("delFans")
    @ResponseBody
    public Integer delFans(Integer buuid,HttpSession session){
        Integer getsession = Gs.getsession(session);
        if (null == getsession){
            return -1;
        }else {
            ps.delFans(getsession,buuid);
        }
        return 1;
    }

}
