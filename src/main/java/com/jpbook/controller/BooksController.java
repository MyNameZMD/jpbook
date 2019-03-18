package com.jpbook.controller;

import com.jpbook.entity.Books;
import com.jpbook.entity.Layui;
import com.jpbook.services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Books")
public class BooksController {
    @Autowired
    BooksServices booksservices;
    @RequestMapping("HqueryAll")
    @ResponseBody
    public Layui HqueryAll(String url, String title, Model model, HttpSession session){
        List<Map<String,Object>> books = booksservices.HqueryAll();
        Layui layui=new Layui();
        layui.setData(books);
        layui.setCount(books.size());
        return layui;
    }
    @RequestMapping("Hadd")
    public String Hadd(Books books) {
        booksservices.Hadd(books);
        return "redirect:queryAll";
    }
   /* @RequestMapping("add")
    public void add(Books books, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        booksservices.add(books);
       return "redirect:queryAll";
    }*/
   /* @RequestMapping("page")
    public String page(Integer pageNumber, Integer pageSize, Model model) {
        List<Books> list = booksservices.page(pageNumber, pageSize);
        model.addAttribute("list", list);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        return "admin";
    }

    @RequestMapping("delete")
    public void del(Integer bookid ,Model model){
        model.addAttribute("bookid",bookid);
        booksservices.delete(bookid);
    }

    @RequestMapping("update")
    public String update(Books books){
        booksservices.update(books);
        return "create";
    }

    @RequestMapping("queryById")
    public String queryById(Model model, Integer bookid){
        List<Books> list=booksservices.queryById(bookid);
        model.addAttribute("list", list);
        return "update";
    }*/
}
