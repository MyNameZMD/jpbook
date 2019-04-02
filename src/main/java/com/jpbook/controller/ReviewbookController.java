package com.jpbook.controller;

import com.jpbook.entity.Reviewbook;
import com.jpbook.entity.Users;
import com.jpbook.service.BooksService;
import com.jpbook.service.ReviewbookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("reviewbook")
public class ReviewbookController {

    @Resource
    ReviewbookService rs;
    @Resource
    BooksService bs;

    @RequestMapping("add")
    public String add(Reviewbook rb){
        rs.add(rb);
        return "redirect:/books/queryBookById?bookid="+rb.getBookid();
    }
    @RequestMapping("queryAll")
    public String queryAll(Model m, Integer bookid, Integer page, HttpSession session){
        List<Users> users = (List<Users>)session.getAttribute("users");
        Integer uuid = null;
        if(null != users){
            uuid = users.get(0).getUuid();
        }
        if(null == page || page <= 0){
            page = 1;
        }
        Integer r = rs.queryAll(bookid,null,uuid).size();
        Integer pagecount =  r % 5 == 0 ? r / 5 : r / 5 + 1;
        m.addAttribute("queryAll",rs.queryAll(bookid,(page-1)*5,uuid));
        m.addAttribute("books",bs.queryBookById(bookid));
        m.addAttribute("book",rs.queryAll(bookid,null,uuid));
        m.addAttribute("page",page);
        m.addAttribute("pagecount",pagecount);
        m.addAttribute("queryZanById",bs.queryZanById(uuid));
        return "remark";
    }
    @RequestMapping("queryById")
    public String queryRevid(Model m,Integer bookid,Integer revid,Integer page,HttpSession session){
        List<Users> users = (List<Users>)session.getAttribute("users");
        Integer uuid = null;
        if(null != users){
            uuid = users.get(0).getUuid();
        }
        if(page == null || page <= 0){
            page = 1;
        }
        Integer r = rs.queryById(revid,uuid,null).size();
        Integer pagecount =  r % 5 == 0 ? r / 5 : r / 5 + 1;
        //书籍评论详情
        m.addAttribute("queryByRevid",rs.queryByRevid(revid,uuid));
        //书籍评论回复查询
        m.addAttribute("queryById",rs.queryById(revid,uuid,(page-1)*5));
        //书籍详情
        m.addAttribute("books",bs.queryBookById(bookid));
        //第几页
        m.addAttribute("page",page);
        //总页数
        m.addAttribute("pagecount",pagecount);
        return "reviewbooks";
    }

}
