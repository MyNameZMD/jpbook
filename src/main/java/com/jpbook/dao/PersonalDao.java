package com.jpbook.dao;

import com.jpbook.entity.Signexp;
import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonalDao {

    public List<Map<String,Object>> fansByeye(Integer uuid);

    public List<Map<String,Object>> guess(Integer uuid);

    public List<Map<String,Object>> monthlyquery(Integer uuid);

    public List<Signexp> findsigne(Integer uuid);

    public Integer addSignexp(Signexp s);

    public Integer editSignexp(Signexp s);

    public Integer editexp(Integer exp,Integer uuid);

    public Integer upnum(Integer uuid);

    public List<Users> queryusers(Integer uuid);

    public Integer editusers(Users u);

    public Integer editicon(String icon,Integer uuid);

}
