package com.jpbook.dao;

import com.jpbook.entity.Advertising;
import com.jpbook.entity.LayuiPage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertisingDao {
    @Select("select ad.*,bs.bookname,e.ename from advertising ad,books bs,emp e where ad.bookid=bs.bookid and e.eid=ad.eid ORDER BY adtime desc LIMIT #{page},#{limit}\n")
    List<Map<String,Object>> queryAll(LayuiPage lp);
    @Insert("INSERT INTO advertising(bookid,pic,eid,adtime) VALUES(#{bookid},#{pic},#{eid},SYSDATE())")
    Integer addAdvertising(Advertising advertising);
}
