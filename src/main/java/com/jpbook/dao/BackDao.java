package com.jpbook.dao;

import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import com.jpbook.entity.Lp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BackDao {
    public Integer count(String tableName);

    public List<Map<String,Object>> novelquery(LayuiPage lp);

    public Integer novelCount(String searchContent);

    public List<Map<String,Object>> userquery(LayuiPage lp);

    public List<Map<String,Object>> authorquery(LayuiPage lp);

    public List<Map<String,Object>> booksincome();

    public List<Map<String,Object>> homepage();

    public Map<String,Object> deal();

    @Select("SELECT time.toptime,IFNULL(sum(r.money),0) he from(\n" +
            "SELECT ADDDATE(y.first, x.d - 1) as toptime\n" +
            "FROM\n" +
            "    (SELECT 1 AS d UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL\n" +
            "    SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14 UNION ALL\n" +
            "    SELECT 15 UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19 UNION ALL SELECT 20 UNION ALL SELECT 21 UNION ALL\n" +
            "    SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25 UNION ALL SELECT 26 UNION ALL SELECT 27 UNION ALL SELECT 28 UNION ALL\n" +
            "    SELECT 29 UNION ALL SELECT 30 UNION ALL SELECT 31) x,\n" +
            "    (SELECT CONCAT(#{month},'-01') as FIRST, DAY(LAST_DAY(str_to_date(#{month},'%Y-%m'))) AS last) y\n" +
            "WHERE x.d <= y.last) time\n" +
            "left join recharge r\n" +
            "on time.toptime = date_format(r.topuptime,'%Y-%m-%d')\n" +
            "where time.toptime<now() group by time.toptime order by time.toptime \n")
    public List<Map<String,Object>> thismonth(String month);

    @Select("select * from emp where eid=#{eid}")
    public Map<String,Object> admin_info(Integer eid);

    @Update("update emp set ename=#{ename},sex=#{sex},ephone=#{ephone},email=#{email} where eid=${eid}")
    public Integer eidtadmin(Emp emp);

    @Select("select epwd from emp where eid=#{eid}")
    public String getpwd(Integer eid);

    @Update("update emp set epwd=#{param1} where eid=#{param2}")
    public Integer editpwd(String epwd,Integer eid);

    @Select("\n" +
            "select (aa.sum+bb.sum) sum from\n" +
            "(select a.month,IFNULL(b.sum,0) sum from (\n" +
            "SELECT convert(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL xc Month), '%m'),SIGNED) as month\n" +
            "FROM ( \n" +
            "\t\t\tSELECT @xi:=@xi+1 as xc from \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 ) xc1, \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 ) xc2,  \n" +
            "\t\t\t(SELECT @xi:=0) xc0 \n" +
            ") xcxc) a LEFT JOIN\n" +
            "(select MONTH(buy.buydate) 'month',sum(FLOOR(c.chapcount/200)) sum from buyrecord buy,chapter c where buy.chapid=c.chapid and YEAR(buy.buydate)=YEAR(NOW()) GROUP BY MONTH(buy.buydate)\n" +
            ") b on a.month=b.month \n" +
            "ORDER BY MONTH) aa INNER JOIN\n" +
            "(\n" +
            "select a.month,IFNULL(b.sum,0) sum from (\n" +
            "SELECT convert(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL xc Month), '%m'),SIGNED) as month\n" +
            "FROM ( \n" +
            "\t\t\tSELECT @xi:=@xi+1 as xc from \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 ) xc1, \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 ) xc2,  \n" +
            "\t\t\t(SELECT @xi:=0) xc0 \n" +
            ") xcxc) a LEFT JOIN\n" +
            "(select sum(rewanum) sum,MONTH(rewatime) 'month' from reward where YEAR(rewatime)=YEAR(NOW()) GROUP BY MONTH(rewatime)) b on a.month=b.month \n" +
            "ORDER BY MONTH) bb on aa.month=bb.month")
    Integer[] getAllIncome();
    @Select("select sum from (\n" +
            "select a.month,IFNULL(b.sum,0) sum from (\n" +
            "SELECT convert(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL xc Month), '%m'),SIGNED) as month\n" +
            "FROM ( \n" +
            "\t\t\tSELECT @xi:=@xi+1 as xc from \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 ) xc1, \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 ) xc2,  \n" +
            "\t\t\t(SELECT @xi:=0) xc0 \n" +
            ") xcxc) a LEFT JOIN\n" +
            "(select MONTH(buy.buydate) 'month',sum(FLOOR(c.chapcount/200)) sum from buyrecord buy,chapter c where buy.chapid=c.chapid and YEAR(buy.buydate)=YEAR(NOW()) GROUP BY MONTH(buy.buydate)\n" +
            ") b on a.month=b.month \n" +
            "ORDER BY MONTH) c")
    Integer[] getAllBuyrecord();
    @Select("select sum from (\n" +
            "select a.month,IFNULL(b.sum,0) sum from (\n" +
            "SELECT convert(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL xc Month), '%m'),SIGNED) as month\n" +
            "FROM ( \n" +
            "\t\t\tSELECT @xi:=@xi+1 as xc from \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 ) xc1, \n" +
            "\t\t\t(SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 ) xc2,  \n" +
            "\t\t\t(SELECT @xi:=0) xc0 \n" +
            ") xcxc) a LEFT JOIN\n" +
            "(select sum(rewanum) sum,MONTH(rewatime) 'month' from reward where YEAR(rewatime)=YEAR(NOW()) GROUP BY MONTH(rewatime)) b on a.month=b.month \n" +
            "ORDER BY MONTH) c")
    Integer[] getAllReward();
    @Select("select (a.sum+b.sum) 'all',a.sum rew,b.sum buy,(c.sum+d.sum) yearAll from (\n" +
            "select sum(rewanum) sum from reward) a,(\n" +
            "select sum(FLOOR(c.chapcount/200)) sum from buyrecord buy,chapter c where buy.chapid=c.chapid) b,(\n" +
            "select sum(rewanum) sum from reward where YEAR(rewatime)=YEAR(NOW())) c,(\n" +
            "select sum(FLOOR(c.chapcount/200)) sum from buyrecord buy,chapter c where buy.chapid=c.chapid and YEAR(buy.buydate)=YEAR(NOW())) d\n" +
            "\n")
    Map<String,Object> getAllAndYear();
    @Select("select a.pen,IFNULL(b.sum,0) rewmoney,IFNULL(c.sum,0) buymoney,IFNULL((b.sum+c.sum),0) allmoney,IFNULL(FLOOR((b.sum/2)+(c.sum/5)),0) duemoney,IFNULL(FLOOR(((b.sum/2)+(c.sum/5))/100),0) actualmoney,IFNULL(FLOOR(a.withdrawmoney),0) withdrawmoney,IFNULL(FLOOR((((b.sum/2)+(c.sum/5))/100)-a.withdrawmoney),0) residuemoney from (\n" +
            "select * from users where pen !='') a LEFT JOIN\n" +
            "(select u.uuid,sum(r.rewanum) sum from reward r,books bs,users u where r.bookid=bs.bookid and bs.uuid=u.uuid group by u.uuid) b on a.uuid=b.uuid left JOIN\n" +
            "(select u.uuid,FLOOR(sum(c.chapcount)/200) sum from buyrecord buy,chapter c,roll r,books bs,users u where buy.chapid=c.chapid and c.rollid=r.rollid and r.bookid=bs.bookid and bs.uuid=u.uuid group by u.uuid) c on b.uuid=c.uuid \n")
    List<Map<String,Object>> getAllAuthorMoney();
    @Select("select pro.pname name,count(u.uuid) value from users u,province pro where u.pro=pro.pid and u.pen!='' GROUP BY pro.pid\n")
    List<Map<String,Object>> getAllAuthorDistribute();
    @Select("SELECT (SELECT count(uuid)  from users) usercount,(SELECT count(uuid)  from users where pen!='') authorcount  from dual\n")
    Map<String,Object> getUsersAndAuthorCount();
    @Select("select bt.btname name,count(b.bookid) value from booktype bt LEFT JOIN books b on bt.btid=b.btid GROUP BY bt.btid\n")
    List<Map<String,Object>> getBookTypeProportion();
    @Select("select a.btid,a.btname,a.chapcount,b.rollcount,c.bookcount,a.chapnum from (\n" +
            "select bt.btid,bt.btname,count(c.chapid) chapcount,IFNULL(sum(c.chapcount),0) chapnum from booktype bt LEFT JOIN books bs on bt.btid=bs.btid LEFT JOIN roll r on bs.bookid=r.bookid LEFT JOIN chapter c on r.rollid=c.rollid GROUP BY bt.btid) a,\n" +
            "(select bt.btid,bt.btname,count(r.rollid) rollcount from booktype bt LEFT JOIN books bs on bt.btid=bs.btid LEFT JOIN roll r on bs.bookid=r.bookid  GROUP BY bt.btid) b,\n" +
            "(select bt.btid,bt.btname,count(b.bookid) bookcount from booktype bt LEFT JOIN books b on bt.btid=b.btid GROUP BY bt.btid) c where a.btname=b.btname and b.btname=c.btname\n")
    List<Map<String,Object>> getAllCountByBtid();
}
