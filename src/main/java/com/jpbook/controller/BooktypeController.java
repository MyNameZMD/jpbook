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

import com.jpbook.entity.Booktype;


@Controller
@RequestMapping("booktype")
public class BooktypeController {
    @Resource
    BooktypeService bs;
    @Resource
    BooksService bks;

    @GetMapping("queryAll")
    public String queryAll(Model m) {
        m.addAttribute("queryAll", bs.queryAll());
        m.addAttribute("queryRecommend", bks.queryRecommend());
        m.addAttribute("queryRecommend2", bks.newBookClick());
        m.addAttribute("queryRecommend3", bks.querybrnum());
        m.addAttribute("cankNewBook",bks.cankNewBook(0,-1));
        m.addAttribute("cankHotsell",bks.cankHotsell(0,-1));
        m.addAttribute("cankQueryVote",bks.cankQueryVote(1,0,-1));
        m.addAttribute("queryClick", bks.queryClick());
        m.addAttribute("queryNewBooks", bks.queryNewBooks());
        m.addAttribute("queryQianli", bks.cankNewPenBook(0,-1));
        m.addAttribute("queryWanben", bks.queryWanben());
        m.addAttribute("queryJingwan", bks.queryJingwan());
        m.addAttribute("recentUpdates",bks.recentUpdates());
        return "index";
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Booktype> query(){
        return bs.query();
    }
    @RequestMapping("queryTypeAndBooks")
    @ResponseBody
    public List<Map<String,Object>> queryTypeAndBooks(){
        return bs.queryTypeAndBooks();
    }
}
