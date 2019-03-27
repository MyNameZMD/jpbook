package com.jpbook.controller;

import com.jpbook.entity.Setting;
import com.jpbook.entity.Users;
import com.jpbook.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("setting")
public class SettingController {
    @Autowired
    SettingService ss;
    @RequestMapping("upSetting")
    @ResponseBody
    public void upSetting(Setting set, HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if (users1==null){return;}
        Setting setting = ss.getSetting(users1.get(0).getUuid());
        if(setting==null){
            ss.addSetting(users1.get(0).getUuid());
        }
        set.setUuid(users1.get(0).getUuid());
        Integer integer = ss.upSetting(set);
    }
    @RequestMapping("getSetting")
    @ResponseBody
    public Setting getSetting(HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if (users1==null){
            return new Setting("white","YaHei",18);
        }
        Setting setting = ss.getSetting(users1.get(0).getUuid());
        if(setting==null){
            ss.addSetting(users1.get(0).getUuid());
            return ss.getSetting(users1.get(0).getUuid());
        }else{
            return setting;
        }
    }
}
