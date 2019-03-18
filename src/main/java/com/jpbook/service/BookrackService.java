package com.jpbook.service;

import com.jpbook.dao.BookrackDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BookrackService {
    @Resource
    BookrackDao bd;

    public List<Map<String,Object>> read(Integer uuid){
        return  bd.read(uuid);
    }

    public List<Map<String,Object>> rack(Integer uuid,String par){
        return bd.rack(uuid,par);
    }

    public Integer del(Integer uuid,String brid){
        return bd.del(uuid,brid);
    }

}
