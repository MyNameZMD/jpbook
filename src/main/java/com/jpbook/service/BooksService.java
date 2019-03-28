package com.jpbook.service;

import com.jpbook.dao.BooksDao;
import com.jpbook.entity.Zan;
import com.jpbook.entity.Books;
import com.jpbook.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BooksService {
    @Resource
    BooksDao bd;

    public List<Map<String,Object>> queryRecommend(Integer retype,Integer page,Integer limit){

        return bd.queryRecommend(retype,page,limit);
    }

    public List<Map<String,Object>> queryClick(){
        return bd.queryClick();
    }

    public List<Map<String,Object>> queryBtype(){
        return bd.queryBtype();
    }
    public  List<Map<String,Object>> queryNewBooks(){
        return bd.queryNewBooks();
    }
    public List<Map<String,Object>> queryQianli(){
        return bd.queryQianli();
    }

    public List<Map<String,Object>> queryWanben(){
        return bd.queryWanben();
    }
    public List<Map<String,Object>> queryJingwan(){
        return bd.queryJingwan();
    }

    public List<Map<String,Object>> queryBookById(Integer bookid){
        return bd.queryBookById(bookid);
    }
    public List<Map<String,Object>> queryUsers(Integer bookid){
        return bd.queryUsers(bookid);
    }
    public List<Map<String,Object>> queryReviewbook(Integer bookid,Integer uuid){
        return bd.queryReviewbook(bookid,uuid);
    }
    public List<Map<String,Object>> queryRolls(Integer bookid){
        return bd.queryRolls(bookid);
    }
    public List<Map<String,Object>> queryChapters(Integer bookid,Integer uuid){
        return bd.queryChapters(bookid,uuid);
    }

    public List<Map<String,Object>> queryBuy(Integer uuid){
        return bd.queryBuy(uuid);
    }

    public List<Map<String,Object>> queryZanById(Integer uuid){
        return bd.queryZanById(uuid);
    }

    public List<Zan> zanExist(Integer revid, Integer uuid,Integer ztype){ return bd.zanExist(revid,uuid,ztype);}

    public Integer editZan(Integer revid,Integer zstate,Integer uuid){return bd.editZan(revid,zstate,uuid);}

    public Integer addZan(Integer revid,Integer uuid,Integer ztype){ return bd.addZan(revid,uuid,ztype);}
    public List<Map<String,Object>> queryByUuid(Users u){
        return bd.queryByUuid(u);
    }
    public Integer add(Books books){return bd.add(books);}
    public List<Map<String,Object>> queryByBookname(String bookname){return bd.queryByBookname(bookname);}
    public List<Map<String,Object>> geturl(Integer bookid){return bd.geturl(bookid);}
    public Integer up(Books books){return bd.up(books);}

    public List<Map<String,Object>> likeQueryBooks(String bookname,Integer limit){
        return bd.likeQueryBooks(bookname,limit);
    }

    public List<Map<String,Object>> likeBooks(String kw,Integer page,Integer limit,String sort){
        return bd.likeBooks(kw,page,limit,sort);
    }
}
