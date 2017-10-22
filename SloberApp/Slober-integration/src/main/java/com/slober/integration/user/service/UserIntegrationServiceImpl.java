/**
 * 
 */
package com.slober.integration.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slober.integration.dto.UserDTO;
import com.slober.integration.entity.SlbUser;
import com.slober.integration.user.dao.UserDAOImpl;
import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 */
@Service
@Transactional
public class UserIntegrationServiceImpl implements UserIntegrationService {

	private static Logger logger = Logger.getLogger(UserIntegrationServiceImpl.class);
	@Autowired
	private UserDAOImpl userDAOImpl;
	@Autowired
	private UserDTO userDTO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.integration.user.service.UserIntegrationService#
	 * authenticateUserIntegration()
	 */
	@Override
	public UserRespVO authenticateUserIntegration(UserReqVO userReqVO) throws Exception {
		logger.info("In AuthenticateUserIntegration for userName ::: " + userReqVO.getUserName());
		final SlbUser slbUser = userDAOImpl.authenticateUser(userReqVO.getUserName(), userReqVO.getPassword());
		return userDTO.slbUSerToUserRespVO(slbUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.integration.user.service.UserIntegrationService#
	 * createUserIntegration(com.slober.util.model.req.UserReqVO)
	 */
	@Override
	public UserRespVO createUserIntegration(UserReqVO userReqVO) throws Exception {
		logger.info("In CreateUserIntegration for userName ::: " + userReqVO.getUserName());
		SlbUser slbUser = userDTO.UserReqVOToSlbUser(userReqVO);
		slbUser = userDAOImpl.createUser(slbUser);
		return userDTO.slbUSerToUserRespVO(slbUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.integration.user.service.UserIntegrationService#
	 * updateUserIntegration(com.slober.util.model.req.UserReqVO)
	 */
	@Override
	public UserRespVO updateUserIntegration(UserReqVO userReqVO) throws Exception {
		logger.info("In UpdateUserIntegration for userName ::: " + userReqVO.getUserName());
		SlbUser slbUser = userDAOImpl.getUser(userReqVO.getUserName());
		slbUser = userDTO.setUpdatedValues(slbUser, userReqVO);
		slbUser = userDAOImpl.updateUser(slbUser);
		return userDTO.slbUSerToUserRespVO(slbUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.slober.integration.user.service.UserIntegrationService#
	 * getUserIntegration(java.lang.String)
	 */
	@Override
	public UserRespVO getUserIntegration(String userName) throws Exception {
		logger.info("In getUserIntegration for userName ::: " + userName);
		SlbUser slbUser = userDAOImpl.getUser(userName);
		return userDTO.slbUSerToUserRespVO(slbUser);
	}

}
