package com.jpbook.controller;

import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Notice;
import com.jpbook.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    NoticeService ns;
    @RequestMapping("queryAll")
    @ResponseBody
    public LayuiPage queryAll(LayuiPage lp){
        return ns.queryAll(lp);
    }
    @RequestMapping("addNotice")
    @ResponseBody
    public Integer addNotice(Notice notice, HttpSession session){
        Emp emp =(Emp)session.getAttribute("emp");
        notice.setEid(emp.getEid());
        return ns.addNotice(notice);
    }
    @RequestMapping("queryAllTopEntity")
    @ResponseBody
    public List<Map<String,Object>> queryAllTopEntity(){
        return ns.queryAllTopEntity();
    }
    @RequestMapping("getNotvalueByNotid")
    @ResponseBody
    public Map<String,Object> getNotvalueByNotid(Integer notid){return ns.getNotvalueByNotid(notid);}
}
