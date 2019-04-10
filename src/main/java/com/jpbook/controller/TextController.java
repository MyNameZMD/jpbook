package com.jpbook.controller;

import com.jpbook.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TextController {
    @Autowired
    TextService ts;
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Map<String,Object>> queryAll(){return ts.queryAll();}
    @RequestMapping("upText")
    @ResponseBody
    public Integer upText(Integer id,String value){return ts.upText(id,value);}
    @RequestMapping("delText")
    @ResponseBody
    public Integer delText(Integer id){return ts.delText(id);}

}
