package com.jpbook.services;

import com.jpbook.dao.EmpDao;
import com.jpbook.entity.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.annotation.Resource;

@Service
public class EmpServices {
    @Resource
    EmpDao empdao;
    public Emp Hlogin(String ename,String epwd) {
        return empdao.Hlogin(ename,epwd);

    }
}
