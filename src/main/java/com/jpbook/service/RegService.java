package com.jpbook.service;

import com.jpbook.dao.RegDao;
import com.jpbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class RegService {

    @Resource
    RegDao rd;

    public Integer queryPhone(String phone){
        return rd.queryPhone(phone);
    }

    public Integer adduser(Users u){
        u.setUname("书友"+new Date().getTime());
        return rd.adduser(u);
    }

    public Integer seluser(String phone){
        return rd.seluser(phone);
    }
    public Integer def1(Integer uuid){
        return rd.def1(uuid);
    }
    public Integer def2(Integer uuid){
        return rd.def2(uuid);
    }
}
