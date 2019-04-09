package com.jpbook.controller;

import com.jpbook.entity.City;
import com.jpbook.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    CityService cs;
    @RequestMapping("getCityByPid")
    @ResponseBody
    public List<City> getCityByPid(Integer pid){
        return cs.getCityByPid(pid);
    }
}
