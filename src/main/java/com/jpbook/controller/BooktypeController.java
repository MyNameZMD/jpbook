package com.jpbook.controller;

import com.jpbook.service.BooksService;
import com.jpbook.service.BooktypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("booktype")
public class BooktypeController {
    @Resource
    BooktypeService bs;
    @Resource
    BooksService bks;

    @GetMapping("queryAll")
    public String queryAll(Model m){
        m.addAttribute("queryAll",bs.queryAll());
        m.addAttribute("queryRecommend",bks.queryRecommend(1,0,18));
        m.addAttribute("queryRecommend2",bks.queryRecommend(2,0,18));
        m.addAttribute("queryRecommend3",bks.queryRecommend(3,0,12));
        m.addAttribute("queryClick",bks.queryClick());
        m.addAttribute("queryNewBooks",bks.queryNewBooks());
        m.addAttribute("queryQianli",bks.queryQianli());
        m.addAttribute("queryWanben",bks.queryWanben());
        m.addAttribute("queryJingwan",bks.queryJingwan());
        return "index";
    }
}
