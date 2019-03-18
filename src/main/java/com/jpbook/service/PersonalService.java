package com.jpbook.service;

import com.jpbook.dao.PersonalDao;
import com.jpbook.entity.Signexp;
import com.jpbook.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonalService {
    @Resource
    PersonalDao pd;

    public List<Map<String,Object>> fansByeye(Integer uuid){
        return pd.fansByeye(uuid);
    }

    public List<Map<String,Object>> guess(Integer uuid){
        return  pd.guess(uuid);
    }

    public List<Map<String,Object>> monthlyquery(Integer uuid){
        return pd.monthlyquery(uuid);
    }

    public List<Signexp> findsigne(Integer uuid){
        return pd.findsigne(uuid);
    }

    public Integer addSignexp(Signexp s){
        return  pd.addSignexp(s);
    }

    public Integer editSignexp(Signexp s){
        return  pd.editSignexp(s);
    }

    public Integer upnum(Integer uuid){
        return pd.upnum(uuid);
    }

    public Integer editexp(Integer exp,Integer uuid){
        return pd.editexp(exp,uuid);
    }

    public List<Users> queryusers(Integer uuid){
        return pd.queryusers(uuid);
    }

    public Integer editusers(Users u){
        return pd.editusers(u);
    }

    public Integer editicon(String icon,Integer uuid){
        return pd.editicon(icon,uuid);
    }

}
