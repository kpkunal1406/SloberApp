/**
 * 
 */
package com.slober.integration.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slober.integration.entity.SlbUser;
import com.slober.integration.util.HibernateUtil;

/**
 * @author Kunal
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	/*
	 * 
	 * @see com.slober.integration.user.dao.UserDAO#getAllEmployees()
	 */
	@Override
	public List<SlbUser> getAllUsers() throws Exception {
		return hibernateUtil.fetchAll(SlbUser.class);
	}

	/*
	 * 
	 * 
	 * @see com.slober.integration.user.dao.UserDAO#getUserByUserName(java.lang.
	 * String)
	 */
	@Override
	public SlbUser authenticateUser(String userName, String password) throws Exception {
		String query = "SELECT s FROM SlbUser s WHERE s.username = '" + userName + "' and s.password = '" + password
				+ "'";
		return hibernateUtil.fetch(query, SlbUser.class);
	}

	/*
	 * @see
	 * com.slober.integration.user.dao.UserDAO#createUser(com.slober.integration
	 * .entity.SlbUser)
	 */
	@Override
	public SlbUser createUser(SlbUser slbUser) throws Exception {
		return (SlbUser) hibernateUtil.fetchById(hibernateUtil.create(slbUser), SlbUser.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.slober.integration.user.dao.UserDAO#updateUser(com.slober.integration
	 * .entity.SlbUser)
	 */
	@Override
	public SlbUser updateUser(SlbUser slbUser) throws Exception {
		return hibernateUtil.update(slbUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.integration.user.dao.UserDAO#getUser(java.lang.String)
	 */
	@Override
	public SlbUser getUser(String userName) throws Exception {
		String query = "SELECT s FROM SlbUser s WHERE s.username = '" + userName + "'";
		return hibernateUtil.fetch(query, SlbUser.class);
	}

}
