package com.jpbook.controller;

import com.jpbook.service.PersonageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("pc")
public class PersonageController {
    @Resource
    PersonageService ps;

    @RequestMapping("authorData")
    public String authorData(Integer bid,Model model){
        model.addAttribute("author",ps.authorData(bid));      //作者id
        model.addAttribute("hot",ps.hotSerial(bid,10000));    //作者id   用户id
        model.addAttribute("list",ps.authorBooks(bid,10000)); //作者id   用户id
        return "author_details.html";
    }

    @RequestMapping("home")
    public String homepage(Integer uuid,Model model){
        model.addAttribute("h",ps.homeInfo(uuid));   //作者id ...
        model.addAttribute("q1",ps.q1(uuid));
        model.addAttribute("q2",ps.q2(uuid));
        model.addAttribute("q3",ps.q3(uuid));        //作者id

        model.addAttribute("fansState",ps.fansState(uuid,10000));

        model.addAttribute("userbooks",ps.usersBooks(uuid,10000));

        return "homepage.html";
    }

    @RequestMapping("fansAdd")
    @ResponseBody
    public Integer addfans(Integer buuid){
        ps.fansAdd(10000,buuid);
        return 1;
    }

    @RequestMapping("delFans")
    @ResponseBody
    public Integer delFans(Integer buuid){
        ps.delFans(10000,buuid);
        return 1;
    }

}
