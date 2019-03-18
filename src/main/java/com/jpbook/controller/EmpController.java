package com.jpbook.controller;

import com.jpbook.entity.Emp;
import com.jpbook.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Emp")
public class EmpController {
    @Autowired
    EmpServices es;
    @RequestMapping(value = "Hlogin")
    @ResponseBody
    public String Hlogin(String ename,String epwd,Model model) {
        Emp hlogin = es.Hlogin(ename, epwd);
        if (hlogin==null) {
            return "0";
        } else {
            model.addAttribute("Hloginname", hlogin);
            return "1";
        }
    }
}
