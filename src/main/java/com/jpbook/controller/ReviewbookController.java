package com.jpbook.controller;

import com.jpbook.entity.Reviewbook;
import com.jpbook.service.ReviewbookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("reviewbook")
public class ReviewbookController {

    @Resource
    ReviewbookService rs;

    @RequestMapping("add")
    public String add(Reviewbook rb){
        rs.add(rb);
        return "redirect:/books/queryBookById?bookid="+rb.getBookid();
    }
}
