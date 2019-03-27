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
import java.text.SimpleDateFormat;
import java.util.*;

import com.jpbook.entity.Books;

import com.jpbook.service.ChapterService;
import com.jpbook.service.RollService;
import com.jpbook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("books")
public class BooksController {
    @Resource
    BooksService bs;
    @Autowired
    RollService rs;
    @Autowired
    ChapterService cs;

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
        m.addAttribute("queryReviewbook",bs.queryReviewbook(bookid));
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
    public Integer zanExist(Integer revid,HttpSession session){
        List<Users> user = (List<Users>)session.getAttribute("users");
        Users u = user.get(0);
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
        List<Users> users = (List<Users>) session.getAttribute("users");
        Users u = users.get(0);
        return bs.editZan(revid,zstate,u.getUuid());
    }
    @RequestMapping("addZan")
    @ResponseBody
    public Integer addZan(Integer revid,Integer zstate,HttpSession session){
        List<Users> users = (List<Users>) session.getAttribute("users");
        Users u = users.get(0);
        return bs.addZan(revid,u.getUuid());
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

    @RequestMapping("queryByUuid")
    @ResponseBody
    public  List<Map<String, Object>> queryByUuid(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Users u=new Users();
        u.setUuid(users1.get(0).getUuid());
        List<Map<String, Object>> bks = bs.queryByUuid(u);
        System.out.println(bks);
        return bks;
    }
    @RequestMapping("add")
    @ResponseBody
    public int add(Books books, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        int i = bs.queryByBookname(books.getBookname()).size();
        if (i>0){
            return 0;
        }
        FileUtil.File(books.getBookname()+"\\第一卷");
        books.setUrl(books.getBookname());
        books.setUuid(users1.get(0).getUuid());
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
    public Integer up(Books books,String oldBookname,HttpSession session){
        System.out.println("books"+books);
        int i = bs.queryByBookname(books.getBookname()).size();
        if (i>0 && !books.getBookname().equals(oldBookname)){
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
    @RequestMapping("queryBookByState")
    @ResponseBody
    public List<Map<String,Object>> queryBookByState(Integer Index,Integer btid,Integer bookstate,Integer rollmoney,Integer updatetime,Integer startSum,Integer endSum,String order){
        Integer startIndex=(Index-1)*8;
        System.out.println(startIndex+" "+btid+" "+bookstate+" "+rollmoney+" "+updatetime+" "+startSum+" "+endSum+" "+order);
        return bs.queryBookByState(startIndex,8,btid,bookstate,rollmoney,updatetime,startSum,endSum,order);
    }
    @RequestMapping("getMonthAndRecAndReward")
    @ResponseBody
    public Map<String,Object> getMonthAndRecAndReward(Integer bookid){
        return bs.getMonthAndRecAndReward(bookid).get(0);
    }
    @RequestMapping("queryMonthAndRecAndReward")
    @ResponseBody
    public List<Map<String,Object>> queryMonthAndRecAndReward(Integer bookid){
        List<Map<String, Object>> maps = bs.queryMonthAndRec(bookid);
        List<Map<String, Object>> maps1 = bs.queryReward(bookid);
        maps.addAll(maps1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Collections.sort(maps, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Date time=null;
                Date time1 =null;
                try{
                    time= sdf.parse(o1.get("time").toString());
                    time1=sdf.parse(o2.get("time").toString());
                }catch (Exception e){

                }
                if (time.compareTo(time1)>0){
                    return 1;
                }
                if (time.compareTo(time1)==0){
                    return 0;
                }
                return -1;
            }
        });
        return maps;
    }
}
