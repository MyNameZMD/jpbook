package com.jpbook.controller;

import com.jpbook.entity.Users;
import com.jpbook.service.BookrackService;
import com.jpbook.util.Gs;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bookrack")
public class BookrackController {

    @Resource
    BookrackService bs;

    @RequestMapping("read")
    public List<Map<String,Object>> read(HttpSession session){
        return bs.read(Gs.getsession(session));
    }

    @RequestMapping("rack")
    public List<Map<String,Object>> rack(String par,HttpSession session){
        return bs.rack(Gs.getsession(session),par);
    }

    @RequestMapping("del")
    public Integer del(String brid, HttpSession session){
        return bs.del(Gs.getsession(session),brid);
    }
    @RequestMapping("add")
    public Integer add(Integer bookid,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if (users1==null){
            return -1;
        }
        return bs.addBookrack(users1.get(0).getUuid(), bookid);
    }
    @RequestMapping("ckBookrackExist")
    @ResponseBody
    public Integer ckBookrackExist(Integer bookid,HttpSession session){
        List<Users> users1 = (List<Users>)session.getAttribute("users");
        if (users1==null){
            return -1;
        }else {
            List<Map<String, Object>> maps = bs.ckBookrackExist(users1.get(0).getUuid(), bookid);
            if (maps==null || maps.size()==0){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
