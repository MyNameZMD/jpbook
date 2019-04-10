package com.jpbook.controller;

import com.jpbook.entity.Advertising;
import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import com.jpbook.service.AdvertisingService;
import com.jpbook.util.DateUtil;
import com.jpbook.util.Gs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("advertising")
public class AdvertisingController {
    @Autowired
    AdvertisingService as;
    @RequestMapping("queryAll")
    @ResponseBody
    public LayuiPage queryAll(LayuiPage lp){
        return as.queryAll(lp);
    }
    @RequestMapping("addAdvertising")
    @ResponseBody
    public Integer addAdvertising(String file, Advertising advertising, HttpSession session){
        Emp emp =(Emp)session.getAttribute("emp");
        advertising.setEid(emp.getEid());
            advertising.setPic(file.substring(file.lastIndexOf('\\')+1));
        return as.addAdvertising(advertising);
    }
    @RequestMapping("queryAllTopFive")
    @ResponseBody
    public List<Map<String,Object>> queryAllTopFive(){
        return as.queryAllTopFive();
    }
}
