package com.jpbook.dao;

import com.jpbook.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityDao {
    @Select("select * from city where pid=#{pid}")
    List<City> getCityByPid(Integer pid);

}
