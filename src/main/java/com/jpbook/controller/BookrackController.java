package com.jpbook.controller;

import com.jpbook.service.BookrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("bookrack")
public class BookrackController {
    @Autowired
    BookrackService bs;
    @RequestMapping("add")
    @ResponseBody
    public Integer add(Integer bookid){
        return bs.addBookrack(10000, bookid);
    }
}
