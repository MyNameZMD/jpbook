package com.jpbook.service;

import com.jpbook.dao.ChapterDao;
import com.jpbook.entity.Chapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChapterService {
    @Resource
    ChapterDao cd;
    public Integer add(Chapter chapter){
        return cd.add(chapter);
    }
    public Integer getChapnum(Integer rollid){return cd.getChapnum(rollid);}
    public List<Map<String,Object>> getByChapname(String chapname){return cd.getByChapname(chapname);}
    public List<Map<String,Object>> getByBookid(Integer bookid){return cd.getByBookid(bookid);}
    public List<Map<String,Object>> getByBookidRecycle(Integer bookid){return cd.getByBookidRecycle(bookid);}
    public List<Map<String,Object>> getByChapid(Integer chapid){return cd.getByChapid(chapid);}
    public List<Map<String,Object>> getChapter(Integer chapid){return cd.getChapter(chapid);}
    public Integer up(Chapter chapter){return cd.up(chapter);}
    public Integer sentup(Chapter chapter){return cd.sentup(chapter);}
    public Integer updel(Integer chapid){return cd.updel(chapid);}
    public Integer updrafts(Integer chapid){return cd.updrafts(chapid);}
    public Integer del(Integer chapid){return cd.del(chapid);}
    public Integer upurl(Integer bookid){return cd.upurl(bookid);}
    public List<Map<String,Object>> getInformationByChapid(Integer chapid,Integer uuid){return cd.getInformationByChapid(chapid,uuid);}
}
