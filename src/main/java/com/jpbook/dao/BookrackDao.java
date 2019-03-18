package com.jpbook.dao;

import com.jpbook.entity.Bookrack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookrackDao {
    @Insert("INSERT INTO bookrack VALUES(null,#{param1},#{param2})\n")
    Integer addBookrack(Integer uuid, Integer bookid);
}
