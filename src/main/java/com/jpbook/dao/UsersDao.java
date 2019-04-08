package com.jpbook.dao;

import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersDao {
    @Select("select s1.*,s2.count,(s1.chapcount/100000*s2.count) remuneration from \n" +
            "(select bs.uuid,bs.bookid,bs.bookname,bs.btid,bs.bookstate,bs.createtime,bs.icon,\n" +
            "bs.sex,bs.bookreferral,r.rollid,r.rollname,r.rollnum,r.updatetime rollupdatetime,\n" +
            "c.chapid,c.chapvalue,c.chapnum,c.chapmoney,c.chapstate,c.chaptime,c.updatetime chapupdatetime,\n" +
            "c.url,c.chapsum,c.chapname,c.chapcount,u.uname\n" +
            "from books bs,roll r,chapter c,users u\n" +
            "where bs.bookid=r.bookid and r.rollid=c.rollid and bs.uuid=u.uuid) s1,(\n" +
            "select chapid,count(buyid) count from statistics where buydate>#{param1} and buydate<#{param2} GROUP BY chapid) s2\n" +
            "where s1.chapid=s2.chapid and s1.uuid=#{param3}")
    List<Map<String,Object>> getRemuneration(String startTime,String endTime,Integer uuid);
    @Update("UPDATE users SET pen=#{pen},sex=#{sex},email=#{email},qqid=#{qqid},realname=#{realname},idcard=#{idcard},pro=#{pro},city=#{city} where uuid=#{uuid}\n")
    Integer upWriter(Users users);
    @Select("select * from users where pen=#{pen}")
    Users getUsersByPen(String pen);
    @Update("UPDATE users set withdrawmoney=withdrawmoney+#{param1} where uuid=#{param2}\n")
    Integer withdraw(Double money,Integer uuid);
    @Select("select money from users where uuid=#{uuid}\n")
    Integer getNewMoney(Integer uuid);
    @Update("update users set money=money-#{param2} where uuid=#{param1}\n")
    Integer rewardNew(Integer uuid,Integer money);

    /**
     * 模糊查询作者
     * @param uname
     * @return
     */
    public List<Map<String,Object>> likeQueryUsers(String uname);
    @Select("select (a.remuneration+b.rewanum) summoney,(select withdrawmoney from users where uuid=#{uuid}) withdrawmoney from (\n" +
            "\tselect sum(s1.chapcount/100000*s2.count) remuneration from \n" +
            "\t(select DISTINCT c.chapid,bs.uuid,bs.bookid,bs.bookname,bs.btid,bs.bookstate,bs.createtime,bs.icon,\n" +
            "\tbs.sex,bs.bookreferral,r.rollid,r.rollname,r.rollnum,r.updatetime rollupdatetime,\n" +
            "\tc.chapvalue,c.chapnum,c.chapmoney,c.chapstate,c.chaptime,c.updatetime chapupdatetime,\n" +
            "\tc.url,c.chapsum,c.chapname,c.chapcount,u.uname\n" +
            "\tfrom books bs,roll r,chapter c,users u\n" +
            "\twhere bs.uuid=u.uuid and r.rollid=c.rollid and bs.bookid=r.bookid  ) s1,(\n" +
            "\tselect chapid,count(buyid) count from statistics GROUP BY chapid) s2\n" +
            "\twhere s1.chapid=s2.chapid and s1.uuid=#{uuid}) a,(\n" +
            "select sum(r.rewanum)/200 rewanum from reward r,users u,books b where r.bookid=b.bookid and u.uuid=r.uuid and r.bookid in(select bookid from books where uuid=#{uuid})\n" +
            ") b")
    Map<String,Object> getSummoenyAndWithdrawmoney(Integer uuid);
}
