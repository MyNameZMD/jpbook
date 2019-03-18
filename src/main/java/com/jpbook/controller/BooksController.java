package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.entity.Zan;
import com.jpbook.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("books")
public class BooksController {
    @Resource
    BooksService bs;

    @RequestMapping("query")
    public String query(){
        return "book";
    }

    @GetMapping("queryBookById")
    public String queryBookById(Model m, Integer bookid,Integer uuid){
        m.addAttribute("queryBookById",bs.queryBookById(bookid));
        m.addAttribute("queryUsers",bs.queryUsers(bookid));
        m.addAttribute("queryReviewbook",bs.queryReviewbook(bookid));
        m.addAttribute("queryRolls",bs.queryRolls(bookid));
        m.addAttribute("queryChapters",bs.queryChapters(bookid,uuid));
        m.addAttribute("queryZanById",bs.queryZanById(uuid));
        return "book";
    }
    @RequestMapping("userExist")
    @ResponseBody
    public Integer userExist(HttpSession session){
        Users users = (Users)session.getAttribute("users");
        if(null == users){
            return 0;
        }
        return 1;
    }
    @RequestMapping("zanExist")
    @ResponseBody
    public Integer zanExist(Integer revid,HttpSession session){
        /*List<Users> user = (List<Users>)session.getAttribute("users");
        Users u = user.get(0);*/
        Users u = new Users();
        u.setUuid(4);
        List<Zan> zan = bs.zanExist(revid,u.getUuid());
        if(0 != zan.size()){
            if(zan.get(0).getZstate() == 1){
                /*如果点赞的状态不为0而为1*/
                return 2;
            }else if(zan.get(0).getZstate() == 0){
                /*点过赞但是已经取消*/
                return 1;
            }
        }
        return 0;
    }
    @RequestMapping("editZan")
    @ResponseBody
    public Integer editZan(Integer revid,Integer zstate,HttpSession session){
        /*List<Users> users = (List<Users>) session.getAttribute("users");
        Users u = users.get(0);*/
        Users u = new Users();
        u.setUuid(4);
        return bs.editZan(revid,zstate,u.getUuid());
    }
    @RequestMapping("addZan")
    @ResponseBody
    public Integer addZan(Integer revid,Integer zstate,HttpSession session){
        Users u = new Users();
        u.setUuid(4);
        return bs.addZan(revid,u.getUuid());
    }
}
