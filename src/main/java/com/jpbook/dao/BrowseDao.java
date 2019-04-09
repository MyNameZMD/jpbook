package com.jpbook.dao;

import com.jpbook.entity.Browse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrowseDao {
    @Select("select br.* from browse br,chapter c,roll r,books b\n" +
            "where br.chapid=c.chapid and c.rollid=r.rollid and r.bookid=b.bookid and br.uuid=#{param1} and b.bookid=#{param2} ORDER BY btime desc LIMIT 1")
    List<Map<String,Object>> getChapidByUUid(Integer uuid,Integer bookid);
    @Insert("insert into browse(uuid,chapid,btime) VALUES(#{uuid},#{chapid},SYSDATE())\n")
    Integer addBrowse(Browse browse);
}
