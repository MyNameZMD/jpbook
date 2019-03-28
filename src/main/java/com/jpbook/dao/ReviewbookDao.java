package com.jpbook.dao;

import com.jpbook.entity.Reviewbook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewbookDao {
    /**
     * 添加一条书籍评论
     * @param rb
     * @return
     */
    public Integer add(Reviewbook rb);

    /**
     * 查询某一个本书的所有评论
     * @param bookid
     * @return
     */
    public List<Map<String,Object>> queryAll(Integer bookid,Integer page,Integer uuid);

    /**
     * 根据评论的id进行查询
     * @param uuid
     * @param revid
     * @return
     */
    public List<Map<String,Object>> queryByRevid(Integer revid,Integer uuid);

    /**
     * 根据书籍评论Id查询回复信息
     * @param revid
     * @param uuid
     * @return
     */
    public List<Map<String,Object>> queryById(Integer revid,Integer uuid,Integer page);
}
