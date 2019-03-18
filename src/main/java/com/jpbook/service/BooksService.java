package com.jpbook.service;

import com.jpbook.dao.BooksDao;
import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BooksService {
    @Resource
    BooksDao bd;
    public List<Map<String,Object>> queryByUuid(Users u){
        return bd.queryByUuid(u);
    }
    public Integer add(Books books){return bd.add(books);}
    public List<Map<String,Object>> queryByBookname(String bookname){return bd.queryByBookname(bookname);}
    public List<Map<String,Object>> geturl(Integer bookid){return bd.geturl(bookid);}
    public Integer up(Books books){return bd.up(books);}
}
