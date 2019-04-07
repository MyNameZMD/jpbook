package com.jpbook.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonageDao {

    public Map<String,Object> authorData(Integer uuid);

    public Map<String,Object> hotSerial(Integer bid,Integer uid);

    public List<Map<String,Object>> authorBooks(Integer bid,Integer uid);

    public Map<String,Object> homeInfo(Integer uuid);

    public Map<String,Object> q1(Integer uuid);
    public Integer q2(Integer uuid);
    public Integer q3(Integer uuid);

    public Integer fansState(Integer buuid,Integer uuid);

    public Integer fansAdd(Integer uuid,Integer buuid);

    public Integer  delFans(Integer uuid,Integer buuid);

    public List<Map<String,Object>> usersBooks(Integer someuuid,Integer uuid);

    @Insert("insert into bookrack values(null,#{param1},#{param2})\n")
    public Integer addBookrack(Integer uuid, Integer bookid);

}
