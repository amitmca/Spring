package com.jCombat.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.jCombat.bean.UserBean;

public interface ICombatDAO {

	@Autowired
	public abstract void setDataSource(DataSource dataSource);

	public abstract boolean authenticateUser(UserBean userBean);

}