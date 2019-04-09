package com.jpbook.dao;

import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeDao {
    @Select("select n.*,e.ename from notice n,emp e where n.eid=e.eid ORDER BY notTime desc LIMIT #{page},#{limit}")
    List<Map<String,Object>> queryAll(LayuiPage lp);
    @Insert("INSERT into notice(notTitle,notvalue,notTime,eid) values(#{notTitle},#{notvalue},SYSDATE(),#{eid})")
    Integer addNotice(Notice notice);
    @Select("SELECT * from notice where notid=#{notid}\n")
    Map<String,Object> getNotvalueByNotid(Integer notid);
}
