package com.jpbook.controller;

import com.jpbook.service.BookrackService;
import com.jpbook.util.Gs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bookrack")
public class BookrackController {

    @Resource
    BookrackService bs;

    @RequestMapping("read")
    public List<Map<String,Object>> read(HttpSession session){
        return bs.read(Gs.getsession(session));
    }

    @RequestMapping("rack")
    public List<Map<String,Object>> rack(String par,HttpSession session){
        return bs.rack(Gs.getsession(session),par);
    }

    @RequestMapping("del")
    public Integer del(String brid, HttpSession session){
        return bs.del(Gs.getsession(session),brid);
    }
    @RequestMapping("add")
    public Integer add(Integer bookid){
        return bs.addBookrack(10000, bookid);
    }
}
