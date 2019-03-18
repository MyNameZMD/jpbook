package com.jpbook.dao;

import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface BooksDao {
    @Select("select * from books bk left join roll r on bk.bookid=r.bookid left join chapter c on r.rollid=c.rollid LEFT JOIN booktype bt on bk.btid=bt.btid where bk.uuid=#{uuid} GROUP BY bk.bookname")
    List<Map<String,Object>> queryByUuid(Users u);
    @Insert("insert into books(bookname,uuid,btid,bookstate,createtime,url,icon,sex,bookreferral) values(#{bookname},#{uuid},#{btid},0,SYSDATE(),#{url},#{icon},#{sex},#{bookreferral});")
    Integer add(Books books);
    @Select("select * from books where bookname=#{bookanem}")
    List<Map<String,Object>> queryByBookname(String bookname);
    @Select("select * from books where bookid=#{bookid}\n")
    List<Map<String,Object>> geturl(Integer bookid);
    @Update("update books set bookname=#{bookname},btid=#{btid},bookreferral=#{bookreferral},url=#{url} where bookid=#{bookid}")
    Integer up(Books books);
}
