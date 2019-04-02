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
    public List<Map<String,Object>> queryBookByState(Integer startIndex,Integer endIndex,Integer btid,Integer bookstate,Integer rollmoney,Integer updatetime,Integer startSum,Integer endSum,String order){
        return bd.queryBookByState(startIndex,endIndex,btid,bookstate,rollmoney,updatetime,startSum,endSum,order);
    }
    public List<Map<String,Object>> getMonthAndRecAndReward(Integer bookid){return bd.getMonthAndRecAndReward(bookid);}
    public List<Map<String,Object>> queryMonthAndRec(Integer bookid){return bd.queryMonthAndRec(bookid);}
    public List<Map<String,Object>> queryReward(Integer bookid){return bd.queryReward(bookid);}
    public Integer bookEnd(Integer bookid){return bd.bookEnd(bookid);}

    public List<Map<String,Object>> cankNewBook(Integer page){
        return bd.cankNewBook(page);
    }
    public List<Map<String,Object>> cankNewPenBook(Integer page){
        return bd.cankNewPenBook(page);
    }

    public List<Map<String,Object>> cankWeekClick(Integer page){
        return bd.cankWeekClick(page);
    }
    public List<Map<String,Object>> cankQueryVote(Integer type,Integer page){
        return  bd.cankQueryVote(type,page);
    }
    public List<Map<String,Object>> cankBookrack(Integer page){
        return bd.cankBookrack(page);
    }
    public List<Map<String,Object>> cankWanben(Integer type,Integer page){
        return bd.cankWanben(type,page);
    }
    public List<Map<String,Object>> cankQianli(Integer page){
        return bd.cankQianli(page);
    }
    public List<Map<String,Object>> cankHotsell(Integer page){
        return bd.cankHotsell(page);
    }
    public List<Map<String,Object>> download(Integer bookid,Integer uuid){return bd.download(bookid,uuid);}
}
