package com.jpbook.controller;

import com.jpbook.entity.Booktype;
import com.jpbook.service.BooktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("booktype")
public class BooktypeController {
    @Autowired
    BooktypeService bts;
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Booktype> queryAll(){
        return bts.queryAll();
    }
}
