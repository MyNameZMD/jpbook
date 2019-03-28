package com.jpbook.controller;

import com.jpbook.entity.Books;
import com.jpbook.entity.Roll;
import com.jpbook.service.BooksService;
import com.jpbook.service.RollService;
import com.jpbook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("roll")
public class RollController {
    @Autowired
    RollService rs;
    @Autowired
    BooksService bs;
    @RequestMapping("addRoll")
    @ResponseBody
    public int addRoll(Roll roll,HttpSession session){
        List<Map<String, Object>> byRollname = rs.getByRollname(roll.getRollname());
        if (byRollname.size()>0){
            return 0;
        }
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        String url = bs.geturl(Integer.parseInt(bookpresent.get("bookid").toString())).get(0).get("url").toString();
        FileUtil.File(url+"\\"+roll.getRollname());
        roll.setRollnum(rs.getRollnum(Integer.parseInt(bookpresent.get("bookid").toString()))+1);
        roll.setBookid(Integer.parseInt(bookpresent.get("bookid").toString()));
        roll.setUrl(url+"\\"+roll.getRollname());
        System.out.println(roll);
        rs.add(roll);
        return 1;
    }
    @RequestMapping("getByBookid")
    @ResponseBody
    public List<Map<String,Object>> getByBookid(HttpSession session){
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        return rs.getByBookid(Integer.parseInt(bookpresent.get("bookid").toString()));
    }
    @RequestMapping("queryAllAndChapter")
    @ResponseBody
    public List<Roll> queryAllAndChapter(HttpSession session){
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        List<Roll> bookid = rs.queryAllAndChapter(Integer.parseInt(bookpresent.get("bookid").toString()));
        System.out.println("bookid:--==-=_+_+==->"+bookid.get(0).getChapterList());
        return bookid;
    }
    @RequestMapping("queryAllCatalog")
    @ResponseBody
    public List<Roll> queryAllCatalog(Integer bookid){
        List<Roll> catalog = rs.queryAllAndChapter(bookid);
        return catalog;
    }
}
