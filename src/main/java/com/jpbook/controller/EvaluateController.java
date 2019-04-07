package com.jpbook.controller;

import com.jpbook.entity.Evaluate;
import com.jpbook.entity.Users;
import com.jpbook.service.BookrackService;
import com.jpbook.service.EvaluateService;
import com.jpbook.util.DateUtil;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;
    @Autowired
    BookrackService bookrackService;

    @RequestMapping("add")
    @ResponseBody
    public Integer add(HttpSession session, Integer bookid, String evacontent, Integer evalv){
        Evaluate e = new Evaluate();
        List<Users> users = (List<Users>)session.getAttribute("users");
        e.setUuid(users.get(0).getUuid());
        e.setBookid(bookid);
        e.setEvacontent(evacontent);
        e.setEvalv(evalv);
        if(bookrackService.bookidExits(e.getUuid(),e.getBookid()) != null){
            // 书籍里有该用户的收藏记录
            if(evaluateService.queryByUuid(e.getUuid(),e.getBookid()) == null){
                // 评价记录里边没有该用户的评价记录
                return evaluateService.add(e);
            }else{
                //评级记录里边有该用户的评价记录
                if(evaluateService.queryTime(e.getUuid(),e.getBookid()) >= 3){
                    // 评论时间已经超过3分钟 就可以修改评论
                    evaluateService.edit(e);
                    return 2;
                }else{
                    //评论时间没有超过3分钟，不可以评论
                    return 3;
                }
            }
        }
        return 4;
    }
    @RequestMapping("queryByUuid")
    @ResponseBody
    public Evaluate queryByUuid(HttpSession session,Integer bookid){
        List<Users> users = (List<Users>)session.getAttribute("users");
        return evaluateService.queryByUuid(users.get(0).getUuid(),bookid);
    }
}
