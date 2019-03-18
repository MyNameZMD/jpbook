package com.jpbook.service;

import com.jpbook.dao.BooksDao;
import com.jpbook.entity.Zan;
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
    public List<Map<String,Object>> queryReviewbook(Integer bookid){
        return bd.queryReviewbook(bookid);
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

    public List<Zan> zanExist(Integer revid, Integer uuid){ return bd.zanExist(revid,uuid);}

    public Integer editZan(Integer revid,Integer zstate,Integer uuid){return bd.editZan(revid,zstate,uuid);}

    public Integer addZan(Integer revid,Integer uuid){ return bd.addZan(revid,uuid);}
}
