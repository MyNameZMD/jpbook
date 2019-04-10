package com.jpbook.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {

    @Select("select * from text")
    List<Map<String,Object>> queryAll();
    @Update("update text set value=#{param2} where id=#{param1}")
    Integer upText(Integer id,String value);
    @Delete("delete from text where id=#{id}")
    Integer delText(Integer id);
}
