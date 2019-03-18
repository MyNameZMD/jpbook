package com.jpbook.controller;

import com.jpbook.entity.Setting;
import com.jpbook.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("setting")
public class SettingController {
    @Autowired
    SettingService ss;
    @RequestMapping("upSetting")
    @ResponseBody
    public void upSetting(Setting set){
        Setting setting = ss.getSetting(10000);
        if(setting==null){
            ss.addSetting(10000);
        }
        set.setUuid(10000);
        Integer integer = ss.upSetting(set);
    }
    @RequestMapping("getSetting")
    @ResponseBody
    public Setting getSetting(){
        Setting setting = ss.getSetting(10000);
        if(setting==null){
            ss.addSetting(10000);
            return ss.getSetting(10000);
        }else{
            return setting;
        }
    }
}
