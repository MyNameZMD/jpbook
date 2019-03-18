package com.jpbook.controller;

import com.jpbook.entity.Signexp;
import com.jpbook.entity.Users;
import com.jpbook.service.PersonalService;
import com.jpbook.util.DateUtil;
import com.jpbook.util.Gs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("per")
public class PersonalController {

    @Resource
    PersonalService ps;

    @RequestMapping("fansByeye")
    public List<Map<String,Object>> fansByeye(HttpSession session){
        return ps.fansByeye(Gs.getsession(session));
    }

    @RequestMapping("guess")
    public List<Map<String,Object>> guess(HttpSession session){
        return ps.guess(Gs.getsession(session));
    }

    @RequestMapping("monthlyquery")
    public List<Map<String,Object>> monthlyquery(HttpSession session){
        return ps.monthlyquery(Gs.getsession(session));
    }

    @RequestMapping("signexp")
    public Signexp findsigne(Signexp s,HttpSession session) {
        List<Signexp> signInfo = ps.findsigne(Gs.getsession(session));
        if (signInfo.size() == 0){
            s.setSigntime(new Date());
            s.setNum(0);
            s.setSignlong(0);
            s.setUuid(Gs.getsession(session));
            ps.addSignexp(s);
        }else {
            if(new SimpleDateFormat("yyyy-MM-dd").format(signInfo.get(0).getSigntime()).equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
                s = signInfo.get(0);
            }else {
                // 修改
                s.setSigntime(new Date());
                s.setNum(0);
                s.setSignlong(0);
                s.setUuid(Gs.getsession(session));
                ps.editSignexp(s);
            }
        }
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try{
            d = sdf.parse("2019-03-12 18:51:10");
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //时间差 秒
        Long second = DateUtil.getSubSecond(new Date(),(Date)session.getAttribute("newdate"))+s.getSignlong();
        s.setSignlong(second.intValue());
        return s;
    }

    @RequestMapping("addexp")
    public Integer addexp(Integer exp,HttpSession session){
        //session.removeAttribute("newdate");
        session.setAttribute("newdate",new Date());
        ps.upnum(Gs.getsession(session));
        ps.editexp(exp,Gs.getsession(session));
        return 1;
    }

    @RequestMapping("queryusers")
    public List<Users> queryusers(HttpSession session){
        return ps.queryusers(Gs.getsession(session));
    }

    @RequestMapping("editusers")
    public Integer editusers(Users u, HttpSession session){
        u.setUuid(Gs.getsession(session));
        ps.editusers(u);
        return 1;
    }

    @RequestMapping("editicon")
    public Integer editicon(MultipartFile photo, HttpSession session) {
        String originalFilename = photo.getOriginalFilename();
        if (null != originalFilename) {
            // 上传路径
            //String realPath = session.getServletContext().getRealPath("E:\\icon");
            // 文件上传,重命名
            //String fileName = realPath + "/" + UUID.randomUUID() + "_"+ originalFilename;
            String fileName = UUID.randomUUID() + "_"+ originalFilename;
            File newFile = new File("E:\\icon\\"+fileName);
            // 另存为
            try {
                photo.transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(newFile+"--->"+fileName);
            ps.editicon(fileName,Gs.getsession(session));
        }
        return 1;
    }



}
