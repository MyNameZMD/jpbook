package com.jpbook.services;

import com.jpbook.dao.BooksDao;
import com.jpbook.entity.Books;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BooksServices {
    @Resource
    BooksDao booksdao;
    public List<Map<String,Object>> HqueryAll(){
        return booksdao.HqueryAll();
    }
    public void Hadd(Books books){
        booksdao.Hadd(books);
    }
   /* public List<Books> page(Integer pageNumber,Integer pageSize){
        if (null == pageSize) {
            pageSize = 7;
        }

        if (null == pageNumber) {
            pageNumber = 1;
        }
        Integer offset = (pageNumber - 1) * pageSize;
        return booksdao.page(offset, pageSize);
    }

    public void delete(Integer bookid){
        booksdao.delete(bookid);
    }

    public int add(Books books){
        return booksdao.add(books);
    }

    public void update(Books books){
        booksdao.update(books);
    }

    public List<Books> queryById(Integer bookid){
        return booksdao.queryById(bookid);
    }*/
}
