package com.jpbook.dao;

import com.jpbook.entity.Zan;
import org.apache.ibatis.annotations.Mapper;
import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface BooksDao {
    /**
     * 按推荐类型查询出书籍信息（强推，编辑推荐，热门）
     * @param retype （强推，编辑推荐，热门）
     * @return
     */
    public List<Map<String,Object>> queryRecommend(Integer retype,Integer page,Integer limit);

    /**
     * 新锐点击榜  查询本周点击前15名
     * @return
     */
    public List<Map<String,Object>> queryClick();

    /**
     * 查询全部类型的书籍
     * @return
     */
    public List<Map<String,Object>> queryBtype();

    /**
     * 上周入库书籍查询
     * @return
     */
    public List<Map<String,Object>> queryNewBooks();

    /**
     * 新人新书潜力榜
     * @return
     */
    public List<Map<String,Object>> queryQianli();

    /**
     * 完本推荐
     * @return
     */
    public List<Map<String,Object>> queryWanben();

    /**
     * 最近完本书籍
     * @return
     */
    public List<Map<String,Object>> queryJingwan();

    /**
     * 根据书籍ID进行查询出关联的数据信息
     * @param bookid  书籍的编号
     * @return
     */
    public List<Map<String,Object>> queryBookById(Integer bookid);

    /**
     * 查询该书籍的作者信息
     * @param bookid
     * @return
     */
    public List<Map<String,Object>> queryUsers(Integer bookid);

    /**
     * 查询该书籍的评论信息
     * @param bookid
     * @return
     */
    public List<Map<String,Object>> queryReviewbook(Integer bookid);

    /**
     * 根据书籍查询出该书籍的章节
     * @param bookid
     * @return
     */
    public List<Map<String,Object>> queryRolls(Integer bookid);

    /**
     * 查询出该书籍的所有章节
     * @param bookid
     * @return
     */
    public List<Map<String,Object>> queryChapters(Integer bookid,Integer uuid);

    /**
     * 查询该用户购买的章节
     * @param uuid
     * @return
     */
    public List<Map<String,Object>> queryBuy(Integer uuid);

    /**
     * 查询该用户点过赞的评论
     * @param uuid
     * @return
     */
    public List<Map<String,Object>> queryZanById(Integer uuid);

    public List<Zan> zanExist(Integer revid, Integer uuid);

    /**
     * 修改该用户的该评论的状态为1
     * @param revid
     * @param uuid
     * @return
     */
    public Integer editZan(Integer revid,Integer zstate,Integer uuid);

    /**
     * 添加一个新的点赞数据
     * @param revid
     * @param uuid
     * @return
     */
    public Integer addZan(Integer revid,Integer uuid);

    @Select("select * from books bk left join roll r on bk.bookid=r.bookid left join chapter c on r.rollid=c.rollid LEFT JOIN booktype bt on bk.btid=bt.btid where bk.uuid=#{uuid} GROUP BY bk.bookname")
    List<Map<String,Object>> queryByUuid(Users u);
    @Insert("insert into books(bookname,uuid,btid,bookstate,createtime,url,icon,sex,bookreferral) values(#{bookname},#{uuid},#{btid},0,SYSDATE(),#{url},#{icon},#{sex},#{bookreferral});")
    Integer add(Books books);
    @Select("select * from books where bookname=#{bookanem}")
    List<Map<String,Object>> queryByBookname(String bookname);
    @Select("select * from books where bookid=#{bookid}\n")
    List<Map<String,Object>> geturl(Integer bookid);
    @Update("update books set bookname=#{bookname},btid=#{btid},bookreferral=#{bookreferral},url=#{url} where bookid=#{bookid}")
    Integer up(Books books);
    /**
     * 条件查询书籍
     */
    List<Map<String,Object>> queryBookByState(Integer startIndex,Integer endIndex,Integer btid,Integer bookstate,Integer rollmoney,Integer updatetime,Integer startSum,Integer endSum,String order);
    @Select("select month.bookid,IFNULL(month.votemonth,0) votemonth,IFNULL(month.todaymonth,0) todaymonth,\n" +
            "IFNULL(rec.voterec,0) voterec,IFNULL(rec.todayrec,0) todayrec,IFNULL(reward.rewanumrec,0) rewanumrec,\n" +
            "IFNULL(reward.rewanumtoday,0) rewanumtoday from (\n" +
            "SELECT a.bookid,IFNULL(a.votenum,0) votemonth,IFNULL(b.todaymonth,0) todaymonth from (\n" +
            "select bookid,sum(votenum) votenum from vote where bookid=#{bookid} and wtid=2 and date_format(votetime, '%Y%m') = date_format(curdate() , '%Y%m')\n" +
            "GROUP BY bookid) a LEFT JOIN (\n" +
            "select bookid,sum(votenum) todaymonth from vote where bookid=#{bookid} and wtid=2 and date_format(votetime, '%Y%m%d') = date_format(curdate() , '%Y%m%d')) b\n" +
            "on a.bookid=b.bookid) month LEFT JOIN (\n" +
            "SELECT a.bookid,IFNULL(a.votenum,0) voterec,IFNULL(b.number,0) todayrec from (\n" +
            "select bookid,sum(votenum) votenum from vote where bookid=#{bookid} and wtid=1 and YEARWEEK(date_format(votetime,'%Y-%m-%d')) = YEARWEEK(now())\n" +
            "GROUP BY bookid) a left JOIN (\n" +
            "select bookid,sum(votenum) number from vote where bookid=#{bookid} and wtid=1 and date_format(votetime, '%Y%m%d') = date_format(curdate() , '%Y%m%d')) b\n" +
            "on a.bookid=b.bookid) rec on MONTH.bookid=rec.bookid LEFT JOIN (\n" +
            "SELECT a.bookid,IFNULL(a.number,0) rewanumrec,IFNULL(b.number,0) rewanumtoday from (\n" +
            "SELECT bookid,count(*) number from reward where bookid=#{bookid} and YEARWEEK(date_format(rewatime,'%Y-%m-%d')) = YEARWEEK(now())) a LEFT JOIN (\n" +
            "SELECT bookid,count(*) number from reward where bookid=#{bookid} and date_format(rewatime, '%Y%m%d') = date_format(curdate() , '%Y%m%d')) b on a.bookid=b.bookid) reward on rec.bookid=reward.bookid")
    List<Map<String,Object>> getMonthAndRecAndReward(Integer bookid);
    @Select("select v.votetime time,v.bookid,u.uname,1 type,v.votenum num,(case v.wtid when 1 then '推荐' else '月' end) name from vote v,users u where v.uuid=u.uuid and  v.bookid=#{bookid};\n" +
            "")
    List<Map<String,Object>> queryMonthAndRec(Integer bookid);
    @Select("select r.rewatime time,r.bookid,u.uname,2 type,r.rewanum num,'起点币' name from reward r,users u where r.uuid=u.uuid and r.bookid=#{bookid};")
    List<Map<String,Object>> queryReward(Integer bookid);
}
