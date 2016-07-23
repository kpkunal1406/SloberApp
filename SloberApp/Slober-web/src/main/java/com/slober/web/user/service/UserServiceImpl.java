/**
 * 
 */
package com.slober.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slober.integration.user.service.UserIntegrationService;
import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 */
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserIntegrationService userIntegrationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.web.user.service.UserService#authenticateUser()
	 */
	@Override
	public UserRespVO authenticateUser(UserReqVO userReqVO) throws Exception {
		return userIntegrationService.authenticateUserIntegration(userReqVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.slober.web.user.service.UserService#createUser(com.slober.util.model.
	 * req.UserReqVO)
	 */
	@Override
	public UserRespVO createUser(UserReqVO userReqVO) throws Exception {
		return userIntegrationService.createUserIntegration(userReqVO);
	}

}
