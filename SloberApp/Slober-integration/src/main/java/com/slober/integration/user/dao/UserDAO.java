/**
 * 
 */
package com.slober.integration.user.dao;

import java.util.List;

import com.slober.integration.entity.SlbUser;

/**
 * @author Kunal
 *
 */
public interface UserDAO {
	public List<SlbUser> getAllUsers() throws Exception;

	public SlbUser authenticateUser(String userName, String password) throws Exception;

	public SlbUser createUser(SlbUser slbUser) throws Exception;
}
