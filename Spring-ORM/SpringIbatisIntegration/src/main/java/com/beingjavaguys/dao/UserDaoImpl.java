package com.beingjavaguys.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.dao.UserDao;

@Repository
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {
	private static final String NAMESPACE = "user.";

	@Autowired
	@Qualifier("sqlMapClient1")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return getSqlMapClientTemplate().queryForList(NAMESPACE + "listUsers");
	}

	@Override
	public Long insertData(User user) {
		return (Long) getSqlMapClientTemplate().insert(
				NAMESPACE + "insertUser", user);
	}

	@Override
	public void updateData(User user) {
		getSqlMapClientTemplate().update(NAMESPACE + "updateUser", user);
	}

	@Override
	public void deleteData(Long id) {
		getSqlMapClientTemplate().delete(NAMESPACE + "deleteUser", id);
	}

	@Override
	public User getUser(Long id) {
		return (User) getSqlMapClientTemplate().queryForObject(
				NAMESPACE + "getUserById", id);
	}
}
