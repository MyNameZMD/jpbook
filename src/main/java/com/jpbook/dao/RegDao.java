package com.jpbook.dao;

import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegDao {

    public Integer queryPhone(String phone);

    public Integer adduser(Users u);

    public Integer seluser(String phone);

    public Integer def1(Integer uuid);
    public Integer def2(Integer uuid);

}
