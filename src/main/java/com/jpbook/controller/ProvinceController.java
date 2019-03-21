package com.jpbook.controller;

import com.jpbook.entity.Province;
import com.jpbook.service.ProvinceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("province")
public class ProvinceController {
    @Resource
    ProvinceService ps;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<Province> queryAll(){
        List<Province> provinces = ps.queryAll();
        return provinces;
    }
}
