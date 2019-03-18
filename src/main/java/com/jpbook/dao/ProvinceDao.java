package com.jpbook.dao;

import com.jpbook.entity.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceDao {
    /**
     * 查询所有的省份
     * @return
     */
    public List<Province> queryAll();

}
