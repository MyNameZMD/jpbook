package com.jpbook.dao;

import com.jpbook.entity.Bookrack;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookrackDao {

    public List<Map<String,Object>> read(Integer uuid);

    public List<Map<String,Object>> rack(Integer uuid,String par);

    @Delete("delete from bookrack where uuid = #{param1} and  brid in(${brid})")
    public Integer del(Integer uuid,@Param("brid") String brid);


    @Insert("INSERT INTO bookrack VALUES(null,#{param1},#{param2})\n")
    Integer addBookrack(Integer uuid, Integer bookid);

    /**
     * 查询用户对某本书是否已经添加进书架
     * @return
     */
    public Bookrack bookidExits(Integer uuid, Integer bookid);
}
