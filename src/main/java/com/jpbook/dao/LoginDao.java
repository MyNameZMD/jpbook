package com.jpbook.dao;

import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginDao {

    List<Users> landing(String username,String password,String phone,String password2);

    public void addUser(Users u);

    public List<Users> userInfo(String phone);

    public Integer editsignlong(Integer signlong,Integer uuid);

}
