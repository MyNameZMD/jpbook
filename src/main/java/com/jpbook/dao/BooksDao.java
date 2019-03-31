package com.jpbook.dao;

import com.jpbook.entity.Zan;
import org.apache.ibatis.annotations.Mapper;
import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import org.apache.ibatis.annotations.*;

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
    public List<Map<String,Object>> queryReviewbook(Integer bookid,Integer uuid);

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

    public List<Zan> zanExist(Integer revid, Integer uuid,Integer ztype);

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
    public Integer addZan(Integer revid,Integer uuid,Integer ztype);

    /**
     * 模糊搜索书籍
     * @param bookname
     * @return
     */
    public List<Map<String,Object>> likeQueryBooks(String bookname,Integer limit);

    /**
     * 根据首页搜索框中的内容进行查询
     * @param kw 作者名或者是书名
     * @param page 页数
     * @param limit 页面大小
     * @return
     */
    public List<Map<String,Object>> likeBooks(String kw,Integer page,Integer limit,String sort);

    /**
     * 查询新书榜
     * @return
     */
    public List<Map<String,Object>> cankNewBook(Integer page);

    /**
     * 新人新书榜
     * @return
     */
    public List<Map<String,Object>> cankNewPenBook(Integer page);

    /**
     * 当周点击量
     * @return
     */
    public List<Map<String,Object>> cankWeekClick(Integer page);

    /**
     * 查询推荐（周、月、总）
     * @param type
     * @return
     */
    public List<Map<String,Object>> cankQueryVote(Integer type,Integer page);

    /**
     * 查询书籍被收藏的次数排行
     * @param page
     * @return
     */
    public List<Map<String,Object>> cankBookrack(Integer page);

    /**
     * 查询完本的点击量
     * @param types
     * @param page
     * @return
     */
    public List<Map<String,Object>> cankWanben(Integer types,Integer page);

    /**
     * 潜力榜
     * @param page
     * @return
     */
    public List<Map<String,Object>> cankQianli(Integer page);

    /**
     * 24小时热销榜
     * @param page
     * @return
     */
    public List<Map<String,Object>> cankHotsell(Integer page);

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
}
