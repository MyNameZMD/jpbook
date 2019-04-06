package com.jpbook.service;

import com.jpbook.dao.BackDao;
import com.jpbook.dao.NoticeDao;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NoticeService {
    @Resource
    NoticeDao nd;
    @Resource
    BackDao bd;
    public LayuiPage queryAll(LayuiPage lp){
        lp.setCount(bd.count("notice"));
        lp.setData(nd.queryAll(lp));
        return lp;
    }
    public List<Map<String,Object>> queryAllTopEntity(){
        LayuiPage lp=new LayuiPage();
        lp.setLimit(7);
        return nd.queryAll(lp);
    }
    public Integer addNotice(Notice notice){return nd.addNotice(notice);}

    public Map<String,Object> getNotvalueByNotid(Integer notid){return nd.getNotvalueByNotid(notid);}
}
