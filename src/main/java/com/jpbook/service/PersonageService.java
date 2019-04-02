package com.jpbook.service;

import com.jpbook.dao.PersonageDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonageService {

    @Resource
    PersonageDao pd;

    public Map<String,Object> authorData(Integer uuid){
        return pd.authorData(uuid);
    }

    public Map<String,Object> hotSerial(Integer bid,Integer uid){
        if(null == uid){
            uid = -1;
        }
        return pd.hotSerial(bid,uid);
    }

    public List<Map<String,Object>> authorBooks(Integer bid, Integer uid){
        if(null == uid){
            uid = -1;
        }
        return pd.authorBooks(bid,uid);
    }

    public Map<String,Object> homeInfo(Integer uuid){
        return pd.homeInfo(uuid);
    }

    public Map<String,Object> q1(Integer uuid){
        return pd.q1(uuid);
    }
    public Integer q2(Integer uuid){
        return pd.q2(uuid);
    }
    public Integer q3(Integer uuid){
        return pd.q3(uuid);
    }

    public Integer fansState(Integer buuid,Integer uuid){
        if(null == uuid){
            uuid = -1;
        }
        Integer state = pd.fansState(buuid,uuid);
        if (null == state){
            state = -1;
        }
        return state;
    }

    public Integer fansAdd(Integer uuid,Integer buuid){
        return pd.fansAdd(uuid,buuid);
    }

    public Integer delFans(Integer uuid,Integer buuid){
        return pd.delFans(uuid,buuid);
    }

    public List<Map<String,Object>> usersBooks(Integer someuuid,Integer uuid){
        if(null == uuid){
            uuid = -1;
        }
        return pd.usersBooks(someuuid,uuid);
    }


}
