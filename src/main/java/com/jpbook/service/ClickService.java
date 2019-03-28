package com.jpbook.service;

import com.jpbook.dao.ClickDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public class ClickService {
    @Resource
    ClickDao cd;
    public Map<String,Object> getClickByUuidAndChapid(Integer uuid,Integer chapid){return cd.getClickByUuidAndChapid(uuid,chapid);}
    public Integer addNewClick(Integer uuid,Integer chapid){return cd.addNewClick(uuid,chapid);}
    public Integer upNewClick(Integer uuid,Integer chapid){return cd.upNewClick(uuid,chapid);}
}
