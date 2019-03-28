package com.jpbook.service;

import com.jpbook.dao.CityDao;
import com.jpbook.entity.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CityService {
    @Resource
    CityDao cd;
    public List<City> getCityByPid(Integer pid){return cd.getCityByPid(pid);}
}
