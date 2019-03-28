package com.jpbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface WalletDao {
    @Select("select walnum from wallet where uuid=#{uuid} and wtid=2\n")
    Integer getSurplusMonth(Integer uuid);
    @Select("select walnum from wallet where uuid=#{uuid} and wtid=1\n")
    Integer getSurplusRec(Integer uuid);
    @Update("update wallet set walnum=walnum-#{param1} where uuid=#{param2} and wtid=2\n")
    Integer voteMonth(Integer walnum,Integer uuid);
    @Update("update wallet set walnum=walnum-#{param1} where uuid=#{param2} and wtid=1\n")
    Integer voteRec(Integer walnum,Integer uuid);
    @Update("update wallet set walnum=walnum+#{param1} where uuid=#{param2} and wtid=2\n")
    Integer giveMonth(Integer walnum,Integer uuid);
}
