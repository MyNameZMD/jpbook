package com.jpbook.service;

import com.jpbook.dao.AdvertisingDao;
import com.jpbook.dao.BackDao;
import com.jpbook.entity.Advertising;
import com.jpbook.entity.LayuiPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdvertisingService {
    @Resource
    AdvertisingDao ad;
    @Resource
    BackDao bd;
    public LayuiPage queryAll(LayuiPage lp){
        lp.setCount(bd.count("advertising"));
        System.out.println("lp:"+lp);
        lp.setData(ad.queryAll(lp));
        return lp;
    }
    public Integer addAdvertising(Advertising advertising){return ad.addAdvertising(advertising);}
}
