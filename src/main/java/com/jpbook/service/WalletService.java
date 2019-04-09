package com.jpbook.service;

import com.jpbook.dao.WalletDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class WalletService {
    @Resource
    WalletDao wd;
    public Integer getSurplusMonth(Integer uuid){return wd.getSurplusMonth(uuid);}
    public Integer getSurplusRec(Integer uuid){return wd.getSurplusRec(uuid);}
    public Integer voteMonth(Integer walnum,Integer uuid){return wd.voteMonth(walnum,uuid);}
    public Integer voteRec(Integer walnum,Integer uuid){return wd.voteRec(walnum,uuid);}
    public Integer giveMonth(Integer walnum,Integer uuid){return wd.giveMonth(walnum,uuid);}
}
