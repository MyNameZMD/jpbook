package com.jpbook.service;

import com.jpbook.dao.UsersDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class UsersService {
    @Resource
    UsersDao ud;
    public List<Map<String,Object>> getRemuneration(String startTime,String endTime,Integer uuid){return  ud.getRemuneration(startTime,endTime,uuid);};
}
