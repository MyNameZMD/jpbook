package com.jpbook.service;

import com.jpbook.dao.UsersDao;
import com.jpbook.entity.Users;
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
    public Integer upWriter(Users users){return ud.upWriter(users);}
    public Users getUsersByPen(String pen){return ud.getUsersByPen(pen);}
    public Integer withdraw(Double money,Integer uuid){return ud.withdraw(money,uuid);}
    public Integer getNewMoney(Integer uuid){return ud.getNewMoney(uuid);}
    public Integer rewardNew(Integer uuid,Integer money){return ud.rewardNew(uuid,money);}

    /**
     * 模糊查询作者
     * @param uname
     * @return
     */
    public List<Map<String,Object>> likeQueryUsers(String uname){
        return ud.likeQueryUsers(uname);
    }
}
