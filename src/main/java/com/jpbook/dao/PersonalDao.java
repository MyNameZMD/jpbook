package com.jpbook.dao;

import com.jpbook.entity.Recharge;
import com.jpbook.entity.Signexp;
import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonalDao {

    public List<Map<String,Object>> fansByeye(Integer uuid);

    public List<Map<String,Object>> guess(Integer uuid);

    public List<Signexp> findsigne(Integer uuid);

    public Integer addSignexp(Signexp s);

    public Integer editSignexp(Signexp s);

    public Integer editexp(Integer exp,Integer uuid);

    public Integer upnum(Integer uuid);

    public List<Users> queryusers(Integer uuid);

    public Integer editusers(Users u);

    public Integer editicon(String icon,Integer uuid);

    public Integer buy(Integer uuid,Integer money);

    public Integer editmoney(Integer money,Integer uuid);

    public List<Recharge> record1(Integer uuid);

    public List<Map<String,Object>> record2(Integer uuid);

    public List<Map<String,Object>> record3(Integer uuid);

    public Integer wtid1(Integer uuid);

    public Map<String,Object> wtid2(Integer uuid);

    public List<Map<String,Object>> monthlyquery(Integer uuid);

    @Select("select v.voteid,b.bookname,b.bookid,v.votetime,v.votenum,\n" +
            "(select count(voteid) c from vote where wtid=1 and uuid=#{uuid} \n" +
            "and date_sub(curdate(), interval 30 day) <= date(votetime)) num\n" +
            "from books b,vote v\n" +
            "where v.bookid = b.bookid and v.wtid = 1 and v.uuid = #{uuid} \n" +
            "and date_sub(curdate(), interval 30 day) <= date(v.votetime) \n")
    public List<Map<String,Object>>  recquery(Integer uuid);

    public List<Map<String,Object>> reviewquery(Integer uuid);

    public List<Map<String,Object>> replyquery(Integer uuid);

    public List<Map<String,Object>> mutualquery(Integer uuid);

    public List<Map<String,Object>> eyequery(Integer uuid);

    public List<Map<String,Object>> fansquery(Integer uuid);

    @Select("select count(uuid) from users where uname = #{param1} and uuid != #{param2}")
    public Integer getuname(String uname ,Integer uuid);

}
