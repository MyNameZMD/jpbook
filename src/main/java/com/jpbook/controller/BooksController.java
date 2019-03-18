package com.jpbook.controller;

import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import com.jpbook.service.BooksService;
import com.jpbook.service.ChapterService;
import com.jpbook.service.RollService;
import com.jpbook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("books")
public class BooksController {
    @Autowired
    BooksService bs;
    @Autowired
    RollService rs;
    @Autowired
    ChapterService cs;
    @RequestMapping("queryByUuid")
    @ResponseBody
    public  List<Map<String, Object>> queryByUuid(){
        Users u=new Users();
        u.setUuid(10000);
        List<Map<String, Object>> bks = bs.queryByUuid(u);
        System.out.println(bks);
        return bks;
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(Books books, HttpSession session){
        int i = bs.queryByBookname(books.getBookname()).size();
        if (i>0){
            return 0;
        }
        FileUtil.File(books.getBookname()+"\\第一卷");
        books.setUrl(books.getBookname());
        books.setUuid(10000);
        String image = FileUtil.createImage(books.getBookname());
        books.setIcon(image);
        bs.add(books);
        rs.addNew();
        List<Map<String,Object>> map=bs.queryByBookname(books.getBookname());
        session.setAttribute("bookpresent",map.get(0));
        return 1;
    }
    @RequestMapping("workstoaddandsend")
    @ResponseBody
    public void workstoaddandsend(HttpSession session,Integer bookid){
        System.out.println(bookid);
        Map<String, Object> bookpresent = bs.geturl(bookid).get(0);
        System.out.println("bookpresent:------->"+bookpresent);
        session.setAttribute("bookpresent",bookpresent);
    }
    @RequestMapping("up")
    @ResponseBody
    public Integer up(Books books,HttpSession session){
        System.out.println("books"+books);
        int i = bs.queryByBookname(books.getBookname()).size();
        if (i>0){
            return 0;
        }
        books.setUrl(books.getBookname());
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        books.setBookid(Integer.parseInt(bookpresent.get("bookid").toString()));
        FileUtil.upFileName(bookpresent.get("url").toString(),books.getUrl());
        bs.up(books);
        rs.upurl(books.getBookid());
        cs.upurl(books.getBookid());
        Map<String, Object> newbookpresent = bs.geturl(Integer.parseInt(bookpresent.get("bookid").toString())).get(0);
        System.out.println("bookpresent:------->"+newbookpresent);
        session.setAttribute("bookpresent",newbookpresent);
        return 1;
    }

}
