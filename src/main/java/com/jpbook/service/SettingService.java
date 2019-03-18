package com.jpbook.service;

import com.jpbook.dao.SettingDao;
import com.jpbook.entity.Setting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SettingService {
    @Resource
    SettingDao sd;
    public Integer addSetting(Integer uuid){return sd.addSetting(uuid);}
    public Setting getSetting(Integer uuid){return sd.getSetting(uuid);}
    public Integer upSetting(Setting set){return sd.upSetting(set);}
}
