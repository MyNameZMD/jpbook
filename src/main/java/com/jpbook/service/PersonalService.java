package com.jpbook.service;

import com.jpbook.dao.PersonalDao;
import com.jpbook.entity.Recharge;
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

    public Integer buy(Integer uuid,Integer money){
        return pd.buy(uuid,money);
    }

    public Integer editmoney(Integer money,Integer uuid){
        return pd.editmoney(money,uuid);
    }

    public List<Recharge> record1(Integer uuid){
        return pd.record1(uuid);
    }
    public List<Map<String,Object>> record2(Integer uuid){
        return pd.record2(uuid);
    }
    public List<Map<String,Object>> record3(Integer uuid){
        return pd.record3(uuid);
    }

    public Integer wtid1(Integer uuid){
        return pd.wtid1(uuid);
    }

    public Map<String,Object> wtid2(Integer uuid){
        return pd.wtid2(uuid);
    }

    public List<Map<String,Object>> monthlyquery(Integer uuid){
        return pd.monthlyquery(uuid);
    }

    public List<Map<String,Object>>  recquery(Integer uuid){
        return pd.recquery(uuid);
    }

    public List<Map<String,Object>> reviewquery(Integer uuid){
        return pd.reviewquery(uuid);
    }

    public List<Map<String,Object>> replyquery(Integer uuid){
        return pd.replyquery(uuid);
    }



}
