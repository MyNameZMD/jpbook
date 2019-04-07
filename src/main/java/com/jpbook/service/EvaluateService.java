package com.jpbook.service;

import com.jpbook.dao.EvaluateDao;
import com.jpbook.entity.Evaluate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EvaluateService {
    @Resource
    EvaluateDao evaluateDao;

    public Integer add(Evaluate evaluate){
        return evaluateDao.add(evaluate);
    }
    public Evaluate queryByUuid(Integer uuid,Integer bookid){
        return evaluateDao.queryByUuid(uuid,bookid);
    }
    public Integer edit(Evaluate e){
        return evaluateDao.edit(e);
    }
    public Integer queryTime(Integer uuid,Integer bookid){
        return evaluateDao.queryTime(uuid,bookid);
    }
    public Map<String,Object> zEvaluate(Integer bookid){
        return evaluateDao.zEvaluate(bookid);
    }public List<Map<String,Object>> queryAllByBookid(Integer bookid, Integer page){
        return evaluateDao.queryAllByBookid(bookid,page);
    }
}
