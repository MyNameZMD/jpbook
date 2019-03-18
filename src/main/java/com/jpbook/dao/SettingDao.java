package com.jpbook.dao;

import com.jpbook.entity.Setting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface SettingDao {
    @Insert("INSERT INTO setting VALUES(null,'white','YaHei',18,#{uuid})\n")
    Integer addSetting(Integer uuid);
    @Select("select * from setting where uuid=#{uuid}\n")
    Setting getSetting(Integer uuid);
    @Update("update setting set setcolor=#{setcolor},setfont=#{setfont},setfontsize=#{setfontsize} where  uuid=#{uuid}\n")
    Integer upSetting(Setting set);
}
