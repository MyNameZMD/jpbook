package com.jpbook.service;

import com.jpbook.dao.ReviewbookDao;
import com.jpbook.entity.Reviewbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReviewbookService {
    @Resource
    ReviewbookDao red;

    public Integer add(Reviewbook rb){
        return red.add(rb);
    }

    public List<Map<String,Object>> queryAll(Integer bookid,Integer page,Integer uuid){
        return red.queryAll(bookid,page,uuid);
    }

    public List<Map<String,Object>> queryByRevid(Integer revid,Integer uuid){
        return red.queryByRevid(revid,uuid);
    }

    public List<Map<String,Object>> queryById(Integer revid,Integer uuid,Integer page){
        return red.queryById(revid,uuid,page);
    }
}
