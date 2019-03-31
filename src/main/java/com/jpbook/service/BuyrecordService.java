package com.jpbook.service;

import com.jpbook.dao.BuyrecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class BuyrecordService {
    @Resource
    BuyrecordDao bd;
    public List<Map<String,Object>> getByChapid(Integer chapid){return bd.getByChapid(chapid);}
    public Map<String,Object> queryStatistics(Integer uuid,Integer bookid){return bd.queryStatistics(uuid,bookid);}
    public List<Map<String,Object>> getStatistics(Integer uuid){return bd.getStatistics(uuid);}
    public Integer buyrecordChap(Integer chapid,Integer uuid){return bd.buyrecordChap(chapid,uuid);}
    public List<Map<String,Object>> getByChapidAndUuid(Integer chapid,Integer uuid){return bd.getByChapidAndUuid(chapid,uuid);}
    public Integer[] getUnpurchasedGoodwillMethodByUuid(Integer bookid,Integer uuid){return bd.getUnpurchasedGoodwillMethodByUuid(bookid,uuid);}
}
