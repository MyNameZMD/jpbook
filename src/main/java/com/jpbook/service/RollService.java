package com.jpbook.service;

import com.jpbook.dao.RollDao;
import com.jpbook.entity.Roll;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RollService {
    @Resource
    RollDao rd;
    public Integer addNew(){return rd.addNew();}
    public Integer add(Roll roll){return rd.add(roll);}
    public List<Map<String,Object>> getByRollname(String rollname){return rd.getByRollname(rollname);}
    public List<Map<String,Object>> getByBookid(Integer bookid){return rd.getByBookid(bookid);}
    public Integer getRollnum(Integer bookid){return rd.getRollnum(bookid);}
    public String geturl(Integer bookid){return rd.geturl(bookid);}
    public List<Roll> queryAllAndChapter(Integer bookid){return rd.queryAllAndChapter(bookid);}
    public Integer upurl(Integer bookid){return rd.upurl(bookid);}
    public List<Map<String,Object>> queryMoneyRoll(Integer bookid,Integer uuid){return rd.queryMoneyRoll(bookid,uuid);}
}
