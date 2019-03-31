package com.jpbook.dao;

import com.jpbook.entity.Chapter;
import org.apache.ibatis.annotations.Insert;
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
    @Insert("insert into buyrecord(uuid,chapid,buydate) VALUES(#{param2},#{param1},SYSDATE())\n")
    Integer buyrecordChap(Integer chapid,Integer uuid);
    @Select("SELECT * FROM buyrecord where chapid=#{param1} and uuid=#{param2}")
    List<Map<String,Object>> getByChapidAndUuid(Integer chapid,Integer uuid);
    @Select("select chapid from chapter c,roll r where c.rollid=r.rollid and r.bookid=#{param1} and chapid not in(\n" +
            "select DISTINCT c.chapid from roll r INNER JOIN chapter c ON c.rollid=c.rollid LEFT JOIN buyrecord b on b.chapid=c.chapid LEFT JOIN users u on u.uuid=b.uuid  where r.bookid=#{param1} and b.uuid=#{param2}\n" +
            ") and c.chapstate=1")
    Integer[] getUnpurchasedGoodwillMethodByUuid(Integer bookid,Integer uuid);
}
