package com.raistudies.persistence;

import java.util.List;
import com.raistudies.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface UserService {

	@Insert("INSERT INTO user (name,standard,age,sex) VALUES"
			+ "(#{name},#{standard},#{age},#{sex})")
	@Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
	public void saveUser(User user);

	@Update("UPDATE user SET name = #{name},"
			+ "standard = #{standard}," + "age = #{age}, " + "sex = #{sex} "
			+ "where id = #{id}")
	public void updateUser(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	public void deleteUser(String id);

	@Select("SELECT id,name,standard,age,sex FROM user")
	public List<User> getAllUser();
}
