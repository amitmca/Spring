package com.cg.springbootmybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cg.springbootmybatis.model.Employee;

@Mapper
public interface EmployeeMapper  {
	@Insert("INSERT INTO EMPLOYEE ( name, salary ) VALUES ( #{emp.name}, #{emp.salary})")
    Integer insertEmployee(@Param("emp") Employee emp) throws Exception;
	
	@Select("select * from employee")
    List<Employee> getAllEmployees();
	
	@Select("select * from employee where id = #{id}")
	Employee findById(@Param("id") Integer id);
	
	@Delete("DELETE from employee where id = #{id}")
    Integer deleteById(@Param("id") Integer id);
	
    @Update("UPDATE EMPLOYEE SET name = #{emp.name},salary = #{emp.salary} WHERE id = #{emp.id}")
    Integer updateEmployee(@Param("emp") Employee emp) throws Exception;
}	