package com.jpbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface BuyrecordDao {
    @Select("SELECT * FROM buyrecord where chapid=#{chapid}")
    List<Map<String,Object>> getByChapid(Integer chapid);
    @Select("select * from\n" +
            "(select count(buyid) sum from statistics where uuid=#{param1} and bookid=#{param2}) a,\n" +
            "(select count(buyid) yesterday from statistics where uuid=#{param1} and bookid=#{param2} and buydate=DATE_SUB(curdate(),INTERVAL 1 DAY)) b,\n" +
            "(select avg(num) avg from (select count(buyid) num from statistics where uuid=#{param1} and bookid=#{param2} GROUP BY chapid) avg) c,\n" +
            "(select count(buyid) num from statistics where uuid=#{param1} and bookid=#{param2} GROUP BY chapid ORDER BY num desc LIMIT 1) d")
    Map<String,Object> queryStatistics(Integer uuid,Integer bookid);
    @Select("select b.*, (CASE WHEN s.sum is null THEN 0 ELSE s.sum end) sum,bt.btname from booktype bt RIGHT JOIN books b on b.btid=bt.btid  LEFT JOIN\n" +
            "(SELECT bookid,count(buyid) sum FROM statistics where uuid=#{uuid} group by bookid) s on\n" +
            " b.bookid=s.bookid  where b.uuid=#{uuid}")
    List<Map<String,Object>> getStatistics(Integer uuid);
}
