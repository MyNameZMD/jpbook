package com.jpbook.dao;

import com.jpbook.entity.Vote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteDao {
    @Insert("insert into vote(uuid,wtid,votetime,bookid,votenum) VALUES(#{uuid},2,SYSDATE(),#{bookid},#{votenum})\n")
    Integer voteMonth(Vote vote);
    @Insert("insert into vote(uuid,wtid,votetime,bookid,votenum) VALUES(#{uuid},1,SYSDATE(),#{bookid},#{votenum})\n")
    Integer voteRec(Vote vote);
}
