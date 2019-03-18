package com.jpbook.dao;

import com.jpbook.entity.Booktype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BooktypeDao {
    /**
     * 查询所有书籍类型
     * @return
     */
    public List<Map<String,Object>> queryAll();
}
