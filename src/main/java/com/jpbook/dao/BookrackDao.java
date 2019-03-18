package com.jpbook.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookrackDao {

    public List<Map<String,Object>> read(Integer uuid);

    public List<Map<String,Object>> rack(Integer uuid,String par);

    @Delete("delete from bookrack where uuid = #{param1} and  brid in(${brid})")
    public Integer del(Integer uuid,@Param("brid") String brid);

}
