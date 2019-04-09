package com.jpbook.controller;

import com.jpbook.entity.*;
import com.jpbook.service.*;
import com.jpbook.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    ChapterService cs;
    @Autowired
    RollService rs;
    @Autowired
    BuyrecordService bs;
    @Autowired
    BrowseService brs;
    @Autowired
    ClickService cls;
    @RequestMapping("save")
    @ResponseBody
    public int save(Chapter chapter,String content){
        List<Map<String, Object>> byChapname = cs.getByChapname(chapter.getChapname());
        if (byChapname.size()>0){
            return 0;
        }
        System.out.println("chapter:"+chapter);
        String url = rs.geturl(chapter.getRollid());
        chapter.setChapcount(content.length());
        chapter.setChapstate(0);
        FileUtil.write(url+"\\"+chapter.getChapname()+".txt",content);
        chapter.setUrl(url+"\\\\"+chapter.getChapname()+".txt");
        cs.add(chapter);
        return 1;
    }
    @RequestMapping("issue")
    @ResponseBody
    public int issue(Chapter chapter,String content){
        List<Map<String, Object>> byChapname = cs.getByChapname(chapter.getChapname());
        if (byChapname.size()>0){
            return 0;
        }
        System.out.println("chapter:"+chapter);
        String url = rs.geturl(chapter.getRollid());
        Integer i=cs.getChapnum(chapter.getRollid());
        chapter.setChapnum(i==null?1:i+1);
        chapter.setChapcount(content.length());
        chapter.setChapstate(1);
        FileUtil.write(url+"\\"+chapter.getChapname()+".txt",content);
        chapter.setUrl(url+"\\\\"+chapter.getChapname()+".txt");
        cs.add(chapter);
        return 1;
    }
    @RequestMapping("getByBookid")
    @ResponseBody
    public List<Map<String,Object>> getByBookid(HttpSession session){
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        return cs.getByBookid(Integer.parseInt(bookpresent.get("bookid").toString()));
    }
    @RequestMapping("getByBookidRecycle")
    @ResponseBody
    public List<Map<String,Object>> getByBookidRecycle(HttpSession session){
        Map<String,Object>  bookpresent = (Map<String,Object> )session.getAttribute("bookpresent");
        return cs.getByBookidRecycle(Integer.parseInt(bookpresent.get("bookid").toString()));
    }
    @RequestMapping(value = "read",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String read(Integer chapid){
        List<Map<String, Object>> byBookid = cs.getByChapid(chapid);
        System.out.println(chapid+"---"+byBookid);
        String str = FileUtil.read(byBookid.get(0).get("url") + "");
        return str;
    }
    @RequestMapping("upsave")
    @ResponseBody
    public void upsave(Chapter chapter,String content){
        List<Map<String, Object>> byChapname = cs.getByChapname(chapter.getChapname());
        System.out.println("byChapname:________+++++++"+byChapname);
        String url = rs.geturl(chapter.getRollid());
        chapter.setChapcount(content.length());
        chapter.setChapstate(0);
        chapter.setChapnum(0);
        System.out.println("url__+_+_++_"+url);
        FileUtil.write(url+"\\"+chapter.getChapname()+".txt",content);
        chapter.setUrl(url+"\\\\"+chapter.getChapname()+".txt");
        System.out.println(chapter);

        cs.up(chapter);
    }
    @RequestMapping("upissue")
    @ResponseBody
    public void upissue(Chapter chapter,String content){
        List<Map<String, Object>> byChapname = cs.getByChapname(chapter.getChapname());

        System.out.println("chapter:"+chapter);
        String url = rs.geturl(chapter.getRollid());
        Integer i=cs.getChapnum(chapter.getRollid());
        chapter.setChapnum(i==null?1:i+1);
        chapter.setChapcount(content.length());
        chapter.setChapstate(1);
        FileUtil.write(url+"\\"+chapter.getChapname()+".txt",content);
        chapter.setUrl(url+"\\\\"+chapter.getChapname()+".txt");
        FileUtil.upFileName(byChapname.get(0).get("url")+"",url+"\\"+chapter.getChapname()+".txt");
        cs.up(chapter);
    }
    @RequestMapping("updel")
    @ResponseBody
    public void updel(Integer chapid){
        cs.updel(chapid);
    }
    @RequestMapping("updrafts")
    @ResponseBody
    public void updrafts(Integer chapid){
        cs.updrafts(chapid);
    }
    @RequestMapping("del")
    @ResponseBody
    public void del(Integer chapid){
        cs.del(chapid);
    }
    @RequestMapping("sentupdel")
    @ResponseBody
    public Integer sentupdel(Integer chapid){
        List<Map<String, Object>> byChapid = bs.getByChapid(chapid);
        if (byChapid.size()>0){
            return 0;
        }else {
            cs.updel(chapid);
            return 1;
        }
    }
    @RequestMapping("sentsave")
    @ResponseBody
    public void sentsave(Chapter chapter,String content,String oldname){
        List<Map<String, Object>> byChapname = cs.getByChapid(chapter.getChapid());
        String url = rs.geturl(Integer.parseInt(byChapname.get(0).get("rollid").toString()));
        chapter.setChapcount(content.length());
        chapter.setChapstate(1);
        chapter.setChapnum(0);
        FileUtil.write(url+"\\"+chapter.getChapname()+".txt",content);
        FileUtil.delPaper("f:\\\\books\\\\"+url+"\\\\"+oldname+".txt");
        chapter.setUrl(url+"\\\\"+chapter.getChapname()+".txt");
        System.out.println(chapter);

        cs.sentup(chapter);
    }
    @RequestMapping("getChapContent")
    @ResponseBody
    public List<Object> getChapContent(Integer chapid,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if (users1!=null){
            brs.addBrowse(new Browse(users1.get(0).getUuid(),chapid));
            Map<String, Object> clickByUuidAndChapid = cls.getClickByUuidAndChapid(users1.get(0).getUuid(), chapid);

            if (clickByUuidAndChapid==null){
                cls.addNewClick(users1.get(0).getUuid(), chapid);
            }else{
                cls.upNewClick(users1.get(0).getUuid(), chapid);
            }
        }
        List<Map<String, Object>> byBookid = cs.getChapter(chapid);
        System.out.println(chapid+"---"+byBookid);
        String str = FileUtil.read(byBookid.get(0).get("url") + "");
        System.out.println(str);
        String[] split = str.replace(" ", "").split("\n");
        List<Object> obs=new ArrayList<Object>();
        obs.add(byBookid.get(0));
        obs.add(split);
        return obs;
    }
    @RequestMapping("getInformationByChapid")
    public String  getInformationByChapid(Integer chapid, Model model,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        System.out.println("chapid:"+chapid);
        List<Map<String, Object>> informationByChapid=null;
        if (users1==null){
            informationByChapid=cs.getInformationByChapidNoUuid(chapid);
        }else {
            informationByChapid = cs.getInformationByChapid(chapid, users1.get(0).getUuid());

        }
        System.out.println("informationByChapid"+informationByChapid);
        model.addAttribute("ibc",informationByChapid);
        return "lookBook";
    }
    @RequestMapping("getBookAllMoney")
    @ResponseBody
    public Map<String,Object> getBookAllMoney(Integer bookid,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        Integer uuid=-1;
        if (users1!=null){
            uuid=users1.get(0).getUuid();
        }
        return cs.getBookAllMoney(bookid,uuid);
    }
}
