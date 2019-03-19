package com.jpbook.dao;

import com.jpbook.entity.Reviewbook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewbookDao {
    /**
     * 添加一条书籍评论
     * @param rb
     * @return
     */
    public Integer add(Reviewbook rb);
}
