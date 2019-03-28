package com.jpbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
            "where bs.bookid=r.bookid and r.rollid=c.rollid) s1,(\n" +
            "select chapid,count(buyid) count from statistics where buydate>#{param1} and buydate<#{param2} GROUP BY chapid) s2\n" +
            "where s1.chapid=s2.chapid and s1.uuid=#{param3}")
    List<Map<String,Object>> getRemuneration(String startTime,String endTime,Integer uuid);

    /**
     * 模糊查询作者
     * @param uname
     * @return
     */
    public List<Map<String,Object>> likeQueryUsers(String uname);
}
