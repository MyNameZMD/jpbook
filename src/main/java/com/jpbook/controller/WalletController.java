package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    WalletService ws;
    @RequestMapping("getSurplusMonth")
    @ResponseBody
    public Integer getSurplusMonth(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        return ws.getSurplusMonth(users1.get(0).getUuid());
    }
    @RequestMapping("getSurplusRec")
    @ResponseBody
    public Integer getSurplusRec(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        return ws.getSurplusRec(users1.get(0).getUuid());
    }
}
