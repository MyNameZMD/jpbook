package com.jpbook.service;

import com.jpbook.dao.BooktypeDao;
import com.jpbook.entity.Booktype;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BooktypeService {
    @Resource
    BooktypeDao btd;
    public List<Booktype> queryAll(){
        return btd.queryAll();
    }
}
