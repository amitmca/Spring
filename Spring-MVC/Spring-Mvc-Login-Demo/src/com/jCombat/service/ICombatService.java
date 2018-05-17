package com.jCombat.service;

import com.jCombat.bean.UserBean;

public interface ICombatService {

	public abstract boolean authenticateUser(UserBean userBean);

}