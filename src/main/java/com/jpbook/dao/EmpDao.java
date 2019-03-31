package com.jpbook.dao;

import com.jpbook.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {

   public Emp Hlogin(String ename, String epwd);

}
