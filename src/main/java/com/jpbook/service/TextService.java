package com.jpbook.service;

import com.jpbook.dao.TestDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TextService {
    @Resource
    TestDao td;
    public List<Map<String,Object>> queryAll(){return td.queryAll();}
    public Integer upText(Integer id,String value){return td.upText(id,value);}
    public Integer delText(Integer id){return td.delText(id);}
}
