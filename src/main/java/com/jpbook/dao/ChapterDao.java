package com.jpbook.dao;

import com.jpbook.entity.Chapter;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChapterDao {
    @Insert("insert into chapter(chapvalue,chapnum,rollid,chapcount,chapmoney,chapstate,chaptime,updatetime,url,chapname)\n" +
            "VALUES(#{chapvalue},#{chapnum},#{rollid},#{chapcount},0,#{chapstate},SYSDATE(),SYSDATE(),#{url},#{chapname})")
    Integer add(Chapter chapter);
    @Select("select chapnum from chapter where rollid=#{rollid} ORDER BY chapnum desc LIMIT 1\n")
    Integer getChapnum(Integer rollid);
    @Select("select * from chapter where chapname=#{chapname}")
    List<Map<String,Object>> getByChapname(String chapname);
    @Select("select * from chapter c,roll r,books b where c.rollid=r.rollid and r.bookid=b.bookid and b.bookid=#{bookid} and chapstate=0")
    List<Map<String,Object>> getByBookid(Integer bookid);
    @Select("select * from chapter c,roll r,books b where c.rollid=r.rollid and r.bookid=b.bookid and b.bookid=#{bookid} and chapstate=2")
    List<Map<String,Object>> getByBookidRecycle(Integer bookid);
    @Select("select * from chapter where chapid=#{chapid}")
    List<Map<String,Object>> getByChapid(Integer chapid);
    @Select("select c.*,(CASE WHEN ss2.chapid is null then -1 else ss2.chapid end)  nextchapid,(CASE WHEN ss3.chapid is null then -1 else ss3.chapid end)  afterchapid  \n" +
            "from (select * from chapter where chapid=#{chapid}) c left join\n" +
            "(\n" +
            "select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum>(\n" +
            "select chapnum from chapter where chapid=#{chapid}) \n" +
            "and c.rollid=r.rollid and chapstate=1\n" +
            "and r.bookid =(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{chapid}) \n" +
            "ORDER BY chapnum  LIMIT 1) ss2 on c.rollid=ss2.rollid\n" +
            "LEFT JOIN (select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum<(\n" +
            "select chapnum from chapter where chapid=#{chapid}) \n" +
            "and c.rollid=r.rollid \n" +
            "and chapstate=1 and r.bookid =\n" +
            "(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{chapid}) ORDER BY  chapnum desc LIMIT 1) ss3\n" +
            "on c.rollid=ss3.rollid")
    List<Map<String,Object>> getChapter(Integer chapid);
    @Update("update chapter set chapname=#{chapname},chapvalue=#{chapvalue},chapnum=#{chapnum},rollid=#{rollid},chapcount=#{chapcount},chapmoney=0,chapstate=#{chapstate},updatetime=SYSDATE(),url=#{url} where chapid=#{chapid}")
    Integer up(Chapter chapter);
    @Update("update chapter set chapname=#{chapname},chapvalue=#{chapvalue},chapcount=#{chapcount},chapmoney=0,chapstate=#{chapstate},updatetime=SYSDATE(),url=#{url} where chapid=#{chapid}")
    Integer sentup(Chapter chapter);
    @Update("update chapter set chapstate=2 where chapid=#{chapid}")
    Integer updel(Integer chapid);
    @Update("update chapter set chapstate=0 where chapid=#{chapid}")
    Integer updrafts(Integer chapid);
    @Delete("DELETE from chapter where chapid=#{chapid}")
    Integer del(Integer chapid);
    @Update("UPDATE chapter c set url=CONCAT((SELECT r.url FROM roll r where r.rollid=c.rollid),'\\\\\\\\',substring_index(url,'\\\\',-1)) where c.rollid in (SELECT rollid from roll where bookid=#{bookid})")
    Integer upurl(Integer bookid);
    @Select("select ss1.*,(CASE WHEN ss2.chapid is null then -1 else ss2.chapid end)  nextchapid,(CASE WHEN ss3.chapid is null then -1 else ss3.chapid end)  afterchapid from \n" +
            "(select s1.*,(CASE WHEN s2.count>100000 then s2.count||'万' else s2.count end) count,(CASE WHEN s3.brid is null then -1 else s3.brid end) brid  from (\n" +
            "select b.*,u.pen,bt.btname,r.rollid,r.rollmoney,c.chapid,c.chapname,c.chapcount,c.chaptime from books b,users u,booktype bt,roll r,chapter c where r.bookid=b.bookid and r.rollid=c.rollid and b.btid=bt.btid and b.uuid=u.uuid and  c.chapid=#{param1}) s1,(\n" +
            "select b.bookid,sum(chapcount) count from chapter c,roll r,books b where c.rollid=r.rollid and r.bookid=b.bookid and b.bookid=(select bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{param1})) s2\n" +
            "LEFT JOIN (select * from bookrack where uuid=#{param2} and bookid=(select bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{param1})) s3\n" +
            "on s2.bookid=s3.bookid  \n" +
            "where s1.bookid=s2.bookid) ss1\n" +
            "LEFT JOIN \n" +
            "(\n" +
            "select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum>(\n" +
            "select chapnum from chapter where chapid=#{param1}) \n" +
            "and c.rollid=r.rollid and chapstate=1\n" +
            "and r.bookid =(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{param1}) \n" +
            "ORDER BY chapnum  LIMIT 1) ss2 \n" +
            "on ss2.bookid=ss1.bookid\n" +
            "LEFT JOIN (select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum<(\n" +
            "select chapnum from chapter where chapid=#{param1}) \n" +
            "and c.rollid=r.rollid \n" +
            "and chapstate=1 and r.bookid =\n" +
            "(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{param1}) ORDER BY  chapnum desc LIMIT 1) ss3\n" +
            " on ss3.bookid=ss2.bookid")
    List<Map<String,Object>> getInformationByChapid(Integer chapid,Integer uuid);
    @Select("select ss1.*,(CASE WHEN ss2.chapid is null then -1 else ss2.chapid end)  nextchapid,(CASE WHEN ss3.chapid is null then -1 else ss3.chapid end)  afterchapid ,(-1) brid from \n" +
            "(select s1.*,(CASE WHEN s2.count>100000 then s2.count||'万' else s2.count end) count from (\n" +
            "select b.*,u.pen,bt.btname,r.rollid,r.rollmoney,c.chapid,c.chapname,c.chapcount,c.chaptime from books b,users u,booktype bt,roll r,chapter c where r.bookid=b.bookid and r.rollid=c.rollid and b.btid=bt.btid and b.uuid=u.uuid and  c.chapid=#{chapid}) s1,(\n" +
            "select b.bookid,sum(chapcount) count from chapter c,roll r,books b where c.rollid=r.rollid and r.bookid=b.bookid and b.bookid=(select bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{chapid})) s2\n" +
            "where s1.bookid=s2.bookid) ss1\n" +
            "LEFT JOIN \n" +
            "(\n" +
            "select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum>(\n" +
            "select chapnum from chapter where chapid=#{chapid}) \n" +
            "and c.rollid=r.rollid and chapstate=1\n" +
            "and r.bookid =(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{chapid}) \n" +
            "ORDER BY chapnum  LIMIT 1) ss2 \n" +
            "on ss2.bookid=ss1.bookid\n" +
            "LEFT JOIN (select r.rollid,c.chapid,r.bookid from chapter c,roll r where c.chapnum<(\n" +
            "select chapnum from chapter where chapid=#{chapid}) \n" +
            "and c.rollid=r.rollid \n" +
            "and chapstate=1 and r.bookid =\n" +
            "(select r.bookid from roll r,chapter c where r.rollid=c.rollid and c.chapid=#{chapid}) ORDER BY  chapnum desc LIMIT 1) ss3\n" +
            " on ss3.bookid=ss2.bookid")
    List<Map<String,Object>> getInformationByChapidNoUuid(Integer chapid);
    @Select("select IFNULL(sum(left((c.chapcount/200),LOCATE('.',(c.chapcount/200))-1)),0) money,count(c.chapid) count from books bs,roll r,chapter c where bs.bookid=r.bookid and r.rollid=c.rollid and r.rollmoney=2 and c.chapstate=1 and bs.bookid=#{param1} and chapid not in (select chapid from buyrecord where uuid=#{param2})\n")
    Map<String,Object> getBookAllMoney(Integer bookid,Integer uuid);
    @Select("select IFNULL(sum(left((c.chapcount/200),LOCATE('.',(c.chapcount/200))-1)),0) money from chapter c,roll r where c.rollid=r.rollid and c.chapid=#{chapid} and rollmoney=2 \n")
    Integer getChapMoney(Integer chapid);
}
