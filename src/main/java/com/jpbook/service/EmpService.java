package com.jpbook.service;

import com.jpbook.dao.BackDao;
import com.jpbook.dao.EmpDao;
import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpService {
    @Resource
    EmpDao empdao;
    @Resource
    BackDao bd;
    public Emp Hlogin(String ename,String epwd) {
        return empdao.Hlogin(ename,epwd);
    }
    public LayuiPage getAllEmp(LayuiPage lp){
        lp.setCount(bd.count("emp"));
        lp.setData(empdao.getAllEmp(lp));
        return lp;
    }
    public Integer empDimission(Integer eid){return empdao.empDimission(eid);}
    public Integer empResume(Integer eid){return empdao.empResume(eid);}
    public Integer addEmp(Emp emp){return empdao.addEmp(emp);}
}
