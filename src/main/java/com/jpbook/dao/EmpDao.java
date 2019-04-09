package com.jpbook.dao;

import com.jpbook.entity.Emp;
import com.jpbook.entity.LayuiPage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;

import java.util.List;

@Mapper
public interface EmpDao {

   public Emp Hlogin(String ename, String epwd);
   @Select("select * from emp   LIMIT #{page},#{limit} ")
   List<Emp> getAllEmp(LayuiPage lp);
   @Update("update emp set state=0 where eid=#{eid} \n")
   Integer empDimission(Integer eid);
   @Update("update emp set state=1 where eid=#{eid} \n")
   Integer empResume(Integer eid);
   @Insert("insert into emp(ename,epwd,ephone,eidcard,position,state,sex,email,regtime) VALUES(#{ename},'123456',#{ephone},#{eidcard},1,1,#{sex},#{email},SYSDATE())\n")
   Integer addEmp(Emp emp);
}
