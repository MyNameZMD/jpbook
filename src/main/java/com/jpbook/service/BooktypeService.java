package com.jpbook.service;

import com.jpbook.dao.BooktypeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BooktypeService {

    @Resource
    BooktypeDao bd;

    public List<Map<String,Object>> queryAll(){
        return bd.queryAll();
    }
}
