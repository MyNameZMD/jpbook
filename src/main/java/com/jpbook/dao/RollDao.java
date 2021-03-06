package com.jpbook.dao;

import com.jpbook.entity.Roll;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface RollDao {
    @Insert("insert into roll(rollname,rollnum,bookid,updatetime,url,rollmoney) VALUES('第一卷',1,(select bookid from books ORDER BY bookid desc LIMIT 1),SYSDATE(),(select CONCAT(url,'\\\\第一卷') from books ORDER BY bookid desc LIMIT 1),1)\n")
    Integer addNew();
    @Insert("insert into roll(rollname,rollnum,bookid,updatetime,url,rollmoney) VALUES(#{rollname},#{rollnum},#{bookid},SYSDATE(),#{url},#{rollmoney })\n")
    Integer add(Roll roll);
    @Select("select rollnum from roll where bookid=#{bookid} ORDER BY rollnum desc LIMIT 1")
    Integer getRollnum(Integer bookid);
    @Select("select * from roll where rollname=#{param1} and bookid=#{param2}")
    List<Map<String,Object>> getByRollname(String rollname,Integer bookid);
    @Select("select * from roll  where bookid=#{bookid}")
    List<Map<String,Object>> getByBookid(Integer bookid);
    @Select("select url from roll where rollid=#{rollid}\n")
    String geturl(Integer rollid);
    List<Roll> queryAllAndChapter(Integer bookid);
    @Update("UPDATE roll r set url=CONCAT((SELECT b.url FROM books b where b.bookid=r.bookid),'\\\\\\\\',substring_index(url,'\\\\',-1)) where r.bookid=#{bookid}")
    Integer upurl(Integer bookid);
    List<Map<String,Object>> queryMoneyRoll(Integer bookid,Integer uuid);
}
