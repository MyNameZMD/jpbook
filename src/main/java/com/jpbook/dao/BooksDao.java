package com.jpbook.dao;

import com.jpbook.entity.Zan;
import org.apache.ibatis.annotations.Mapper;

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
}
