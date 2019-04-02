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

}
