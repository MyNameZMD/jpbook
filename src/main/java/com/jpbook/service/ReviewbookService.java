package com.jpbook.service;

import com.jpbook.dao.ReviewbookDao;
import com.jpbook.entity.Reviewbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ReviewbookService {
    @Resource
    ReviewbookDao red;

    public Integer add(Reviewbook rb){
        return red.add(rb);
    }
}
