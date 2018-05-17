package com.jCombat.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.jCombat.bean.UserBean;

@Component
public class CombatDAO implements ICombatDAO {

	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	public boolean authenticateUser(UserBean userBean){
		boolean userExists = false;
		
		/* Provide table name and column name carefully in the sql query below.
		 * here i have a table "userbean" with two column's
		 * "userId" and "password" both of varchar2 type.
		 */
		int rowcount = simpleJdbcTemplate.queryForInt("select count(*) from userbean " +
				" where userId = ? and password = ?",
				userBean.getUserId(),userBean.getPassword());
		if(rowcount==1){
			userExists = true;
		}
		return userExists;
	}

}
