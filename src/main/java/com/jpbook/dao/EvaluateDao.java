package com.jpbook.dao;

import com.jpbook.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluateDao {
    /**
     * 书籍添加一个评价
     * @param evaluate
     * @return
     */
    public Integer add(Evaluate evaluate);

    /**
     * 查询用户是否对该书进行了评价
     * @param uuid
     * @param bookid
     * @return
     */
    public Evaluate queryByUuid(Integer uuid,Integer bookid);

    /**
     * 修改评论的星级
     * @param e
     * @return
     */
    public Integer edit(Evaluate e);

    /**
     * 查询时间差（分钟）
     * @param uuid
     * @param bookid
     * @return
     */
    public Integer queryTime(Integer uuid,Integer bookid);

    /**
     * 查询该本书的评价
     * @param bookid
     * @return
     */
    public Map<String,Object> zEvaluate(Integer bookid);

    public List<Map<String,Object>> queryAllByBookid(Integer bookid,Integer page);
}
