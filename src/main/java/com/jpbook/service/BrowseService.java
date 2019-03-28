package com.jpbook.service;

import com.jpbook.dao.BrowseDao;
import com.jpbook.entity.Browse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BrowseService {
    @Resource
    BrowseDao bd;
    public List<Map<String,Object>> getChapidByUUid(Integer uuid,Integer bookid){return bd.getChapidByUUid(uuid,bookid);}
    public Integer addBrowse(Browse browse){return bd.addBrowse(browse);}
}
