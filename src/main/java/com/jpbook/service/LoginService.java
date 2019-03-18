package com.jpbook.service;

import com.jpbook.dao.LoginDao;
import com.jpbook.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class LoginService {

    @Resource
    LoginDao ld;

    public List<Users> landing(String username,String password,String phone,String password2){
        return ld.landing( username, password, phone, password2);
    }

    public List<Users> userInfo(String phone){
        return ld.userInfo(phone);
    }

    public Integer editsignlong(Integer signlong,Integer uuid){
        return  ld.editsignlong(signlong,uuid);
    }

    public void addUser(Users u){
        u.setUname("书友"+new Date().getTime());
        ld.addUser(u);
    }

    public String phongMessage(String Phone){
        Random ran = new Random();
        String StochasticNum = "";
        for (int i = 1; i < 6; i++) {
            int num = ran.nextInt(10);
            if(num == 0){
                num = 1;
            }
            StochasticNum += num+"";
        }
        PhoneDemo.getRequest2(Phone,StochasticNum);
        return StochasticNum;
    }
}
