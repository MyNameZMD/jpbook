package com.jpbook.dao;

import com.jpbook.entity.Booktype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BooktypeDao {
    @Select("select * from booktype")
    List<Booktype> queryAll();
}
