package com.jpbook.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Map;

@Mapper
public interface ClickDao {
    @Select("select * from click where uuid=#{param1} and bookid=(select bs.bookid from books bs,roll r,chapter c where bs.bookid=r.bookid and r.rollid=c.rollid and c.chapid=#{param2})\n")
    Map<String,Object>  getClickByUuidAndChapid(Integer uuid,Integer chapid);
    @Insert("insert into click(bookid,uuid,clicktime,cnum) VALUES((select bs.bookid from books bs,roll r,chapter c where bs.bookid=r.bookid and r.rollid=c.rollid and c.chapid=#{param2}),#{param1},SYSDATE(),1)\n")
    Integer addNewClick(Integer uuid,Integer chapid);
    @Update("update click set cnum=cnum+1-(case when clicktime=date_format(SYSDATE(),'%Y-%m-%d') then 1 else 0 end),clicktime=SYSDATE() where uuid=#{param1} and bookid=(select bs.bookid from books bs,roll r,chapter c where bs.bookid=r.bookid and r.rollid=c.rollid and c.chapid=#{param2})\n")
    Integer upNewClick(Integer uuid,Integer chapid);
}
