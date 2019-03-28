package com.jpbook.dao;

import com.jpbook.entity.Rbreply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RbreplyDao {
    public Integer add(Rbreply rp);

    /**
     * 查询最新添加的一条数据
     * @return
     */
    public List<Map<String,Object>> queryNewRbreply(Integer replytype,Integer from_uuid);
}
