package com.slober.web.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slober.util.GenericCode;
import com.slober.util.model.req.GenericReqVO;
import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;
import com.slober.web.user.service.UserService;

/**
 * @author Kunal
 *
 *         This UserController is used to serve all request related to user
 *         coming from UI
 */
@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserControllerHelper userControllerHelper;
	@Autowired
	private UserService userService;

	/**
	 * It is used to authenticate user & send response for user
	 */
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public @ResponseBody UserRespVO authenticateUser(@RequestBody GenericReqVO genericReqVO) {
		final UserReqVO userReqVO = genericReqVO.getUserReqVO();
		UserRespVO userRespVO = null;
		try {

			logger.info("******************************************************************************");
			logger.info("        UserAuthentication Request from UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");
			userRespVO = userService.authenticateUser(userReqVO);
			userRespVO = userControllerHelper.getResponseOfAuthenticatUser(userRespVO);
			logger.info("******************************************************************************");
			logger.info("       Sent UserAuthentication Response from UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");

		} catch (Exception e) {
			userRespVO.setMessageId(GenericCode.ERROR);
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error("		 Error while Authenticate User with UserName :: " + userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

	/**
	 * used to create New User
	 * 
	 * @param userReqVO
	 * @return
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody UserRespVO createUser(@RequestBody GenericReqVO genericReqVO) {
		final UserReqVO userReqVO = genericReqVO.getUserReqVO();
		UserRespVO userRespVO = null;
		try {
			logger.info("******************************************************************************");
			logger.info("        Create User Request from UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");

			userRespVO = userService.createUser(userReqVO);

			logger.info("******************************************************************************");
			logger.info("      Sent Create User Response from UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error("		 Error while Create User with UserName :: " + userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

	/**
	 * used to create New User
	 * 
	 * @param userReqVO
	 * @return
	 */
	@RequestMapping(value = "/signOutUser", method = RequestMethod.POST)
	public @ResponseBody UserRespVO signOutUser(@RequestBody GenericReqVO genericReqVO) {
		final UserReqVO userReqVO = genericReqVO.getUserReqVO();
		UserRespVO userRespVO = null;
		try {
			logger.info("******************************************************************************");
			logger.info("        SignOut User Request from UserName ::  ");
			logger.info("******************************************************************************");

			// userRespVO = userService.createUser(userReqVO);

			logger.info("******************************************************************************");
			// logger.info(" Sent SignOut User Response from UserName :: " +
			// userReqVO.getUserName());
			logger.info("******************************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("#############################################################################");
			// logger.error(" Error while SignOut User with UserName :: " +
			// userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

}