package com.jpbook.util;

import com.jpbook.entity.Emp;
import com.jpbook.entity.Users;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class Gs {

    public static Integer getsession(HttpSession session){
        List<Users> users = (List<Users>)session.getAttribute("users");
        if (null == users){
            return null;
        }
        return users.get(0).getUuid();
    }

    public static Integer geteid(HttpSession session){
        Emp emp = (Emp)session.getAttribute("emp");
        if (null == emp){
            return null;
        }
        return emp.getEid();
    }

}
