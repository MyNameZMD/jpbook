package com.jpbook.service;

import com.jpbook.dao.ProvinceDao;
import com.jpbook.entity.Province;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProvinceService {
    @Resource
    ProvinceDao pd;

    public List<Province> queryAll(){
        return pd.queryAll();
    }
}
