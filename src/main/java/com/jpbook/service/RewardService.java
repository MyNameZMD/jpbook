package com.jpbook.service;

import com.jpbook.dao.RewardDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RewardService {
    @Resource
    RewardDao rd;
    public List<Map<String,Object>> getReward(Integer uuid,String startTime,String endTime){return rd.getReward(uuid,startTime,endTime);}
}
