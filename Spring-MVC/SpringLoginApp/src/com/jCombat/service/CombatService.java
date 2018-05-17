package com.jCombat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jCombat.bean.UserBean;
import com.jCombat.dao.ICombatDAO;

@Component
public class CombatService implements ICombatService {

	@Autowired
	private ICombatDAO combatDAO;
	
	public void setCombatDAO(ICombatDAO combatDAO) {
		this.combatDAO = combatDAO;
	}
	public ICombatDAO getCombatDAO() {
		return combatDAO;
	}
	
	public boolean authenticateUser(UserBean userBean){
		return combatDAO.authenticateUser(userBean);
	}
}
