package com.jpbook.dao;


import com.jpbook.entity.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

@Mapper
public interface BooksDao {
    public List<Map<String,Object>> HqueryAll();
    public void Hadd(Books books);
    /*public List<Books> page(Integer offset, Integer pageSize);
    public int delete(Integer bookid);
    public void update(Books books);
    public List<Books> queryById(Integer bookid);*/

}
