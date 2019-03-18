package com.jpbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RewardDao {
    @Select("select r.rewatime,r.rewanum,u.uname,b.bookname from reward r,users u,books b where r.bookid=b.bookid and u.uuid=r.uuid and r.bookid in(select bookid from books where uuid=#{param1}) and rewatime>#{param2} and rewatime < #{param3}\n")
    List<Map<String,Object>> getReward(Integer uuid,String startTime,String endTime);
}
