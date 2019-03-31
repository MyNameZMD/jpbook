package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.entity.Zan;
import com.jpbook.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.jpbook.entity.Books;

import com.jpbook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("books")
public class BooksController {
    @Resource
    BooksService bs;
    @Autowired
    RollService rs;
    @Autowired
    ChapterService cs;
    @Resource
    UsersService us;
    @Autowired
    BooktypeService bts;

    @RequestMapping("query")
    public String query(){
        return "book";
    }

    @GetMapping("queryBookById")
    public String queryBookById(Model m, Integer bookid,HttpSession session){
        List<Users> users = (List<Users>)session.getAttribute("users");
        Integer uuid = null;
        if(null != users){
            uuid = users.get(0).getUuid();
        }
        m.addAttribute("queryBookById",bs.queryBookById(bookid));
        m.addAttribute("queryUsers",bs.queryUsers(bookid));
        m.addAttribute("queryReviewbook",bs.queryReviewbook(bookid,uuid));
        m.addAttribute("queryRolls",bs.queryRolls(bookid));
        m.addAttribute("queryChapters",bs.queryChapters(bookid,uuid));
        m.addAttribute("queryZanById",bs.queryZanById(uuid));
        return "book";
    }
    @RequestMapping("userExist")
    @ResponseBody
    public Integer userExist(HttpSession session){
        List<Users> users = (List<Users>)session.getAttribute("users");
        if(null == users){
            return 0;
        }
        return 1;
    }
    @RequestMapping("zanExist")
    @ResponseBody
    public Integer zanExist(Integer revid,Integer ztype,HttpSession session){
        List<Users> user = (List<Users>)session.getAttribute("users");
        Users u = user.get(0);
        List<Zan> zan = bs.zanExist(revid,u.getUuid(),ztype);
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
        List<Users> users = (List<Users>) session.getAttribute("users");
        Users u = users.get(0);
        return bs.editZan(revid,zstate,u.getUuid());
    }
    @RequestMapping("addZan")
    @ResponseBody
    public Integer addZan(Integer revid,Integer zstate,Integer ztype,HttpSession session){
        List<Users> users = (List<Users>) session.getAttribute("users");
        Users u = users.get(0);
        return bs.addZan(revid,u.getUuid(),ztype);
    }

    @RequestMapping("queryBookByFatie")
    public String queryBookByFatie(Model m,HttpSession session,Integer retype,Integer bookid){
        List<Users> users = (List<Users>) session.getAttribute("users");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("bookname",bs.queryBookById(bookid).get(0).get("bookname"));
        map.put("retype",retype);
        map.put("uuid",users.get(0).getUuid());
        map.put("bookid",bookid);
        m.addAttribute("xinxi",map);
        return "send";
    }

    @RequestMapping("likeQuery")
    @ResponseBody
    public List<Map<String,Object>> likeQuery(String kw){
        Integer limit = 9;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
        Map<String,Object> map = new HashMap<String, Object>();
        if(us.likeQueryUsers(kw).size() == 0){
            limit = 10;
            map.put("listusers",null);
            list.add(null);
        }else{
            System.out.println(us.likeQueryUsers(kw));
            list.add(us.likeQueryUsers(kw).get(0));
        }
        if(bs.likeQueryBooks(kw,limit).size() == 0){
            map.put("listbooks",null);
            list.add(null);
        }else{
            for (int i = 0;i < bs.likeQueryBooks(kw,limit).size();i++){
                list.add(bs.likeQueryBooks(kw,limit).get(i));
            }
        }

        return list;
    }

    @RequestMapping("likeBooks")
    public String likeBooks(Model m,String kw,Integer page,Integer limit,String sort){
        Integer count = bs.likeBooks(kw,null,null,null).size();
        if(page == null || page <= 0){
            page = 1;
        }
        if(limit == null){
            limit = 1;
        }
        Integer pagecount =  count % limit == 0 ? count / limit : (count / limit) + 1;
        List<Map<String,Object>> listBooks = bs.likeBooks(kw,(page-1)*limit,limit,sort);
        m.addAttribute("sort",sort);
        m.addAttribute("page",page);
        m.addAttribute("limit",limit);
        m.addAttribute("pagecount",pagecount);
        m.addAttribute("count",count);
        m.addAttribute("kw",kw);
        m.addAttribute("listBooks",listBooks);
        return "selectbook";
    }

    @RequestMapping("rank")
    public String rank(Model m){
        m.addAttribute("queryAll",bts.queryAll());
        m.addAttribute("queryNewBook",bs.cankNewBook(0));
        m.addAttribute("cankNewPenBook",bs.cankNewPenBook(0));
        m.addAttribute("cankWeekClick",bs.cankWeekClick(0));
        m.addAttribute("dvote",bs.cankQueryVote(1,0));
        m.addAttribute("mvote",bs.cankQueryVote(2,0));
        m.addAttribute("zvote",bs.cankQueryVote(3,0));
        m.addAttribute("cankBookrack",bs.cankBookrack(0));
        m.addAttribute("dclick",bs.cankWanben(1,0));
        m.addAttribute("mclick",bs.cankWanben(2,0));
        m.addAttribute("zclick",bs.cankWanben(null,0));
        m.addAttribute("cankQianli",bs.cankQianli(0));
        m.addAttribute("cankHotsell",bs.cankHotsell(0));
        return "hot";
    }


    /**
     * -------------------------------------------------------------------------
     * @return
     */

    @RequestMapping("queryByUuid")
    @ResponseBody
    public  List<Map<String, Object>> queryByUuid(){
        Users u=new Users();
        u.setUuid(10000);
        List<Map<String, Object>> bks = bs.queryByUuid(u);
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
