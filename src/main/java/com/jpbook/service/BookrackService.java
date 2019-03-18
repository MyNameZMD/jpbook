package com.jpbook.service;

import com.jpbook.dao.BookrackDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BookrackService {
    @Resource
    BookrackDao bd;
    public Integer addBookrack(Integer uuid, Integer bookid){return bd.addBookrack(uuid,bookid);}
}
