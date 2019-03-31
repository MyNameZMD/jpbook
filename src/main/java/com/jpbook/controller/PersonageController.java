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
        model.addAttribute("author",ps.authorData(1));      //作者id
        model.addAttribute("hot",ps.hotSerial(1,2));    //作者id   用户id
        model.addAttribute("list",ps.authorBooks(1,2)); //作者id   用户id
        return "author_details.html";
    }

    @RequestMapping("home")
    public String homepage(Integer uuid,Model model){
        model.addAttribute("h",ps.homeInfo(1));   //作者id ...
        model.addAttribute("q1",ps.q1(1));
        model.addAttribute("q2",ps.q2(1));
        model.addAttribute("q3",ps.q3(1));        //作者id

        model.addAttribute("fansState",ps.fansState(1,27));

        model.addAttribute("userbooks",ps.usersBooks(1,27));

        return "homepage.html";
    }

    @RequestMapping("fansAdd")
    @ResponseBody
    public Integer addfans(Integer buuid){
        ps.fansAdd(27,buuid);
        return 1;
    }

    @RequestMapping("delFans")
    @ResponseBody
    public Integer delFans(Integer buuid){
        ps.delFans(27,buuid);
        return 1;
    }

}
