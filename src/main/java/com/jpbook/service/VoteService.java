package com.jpbook.service;

import com.jpbook.dao.VoteDao;
import com.jpbook.entity.Vote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class VoteService {
    @Resource
    VoteDao vd;
    public Integer voteMonth(Vote vote){return vd.voteMonth(vote);}
    public Integer voteRec(Vote vote){return vd.voteRec(vote);}
}
