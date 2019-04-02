package com.jpbook.service;

import com.jpbook.dao.RbreplyDao;
import com.jpbook.entity.Rbreply;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RbreplyService {
    @Resource
    RbreplyDao rd;

    public Integer add(Rbreply rp){
        return rd.add(rp);
    }

    public List<Map<String,Object>> queryNewRbreply(Integer replytype, Integer from_uuid){
        return rd.queryNewRbreply(replytype,from_uuid);
    }

    public List<Map<String,Object>> queryRbRbreply(Integer revid){
        return rd.queryRbRbreply(revid);
    }
}
