package com.slober.web.user.controller;

import java.io.File;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
 * 
 */
@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserControllerHelper userControllerHelper;
	@Autowired
	private UserService userService;
	@Resource(name = "configProperties")
	private Properties configProperties;

	/**
	 * It is used to authenticate user & send response for user
	 * 
	 * @param genericReqVO
	 * @return UserRespVO
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
			logger.info("       Sent UserAuthentication Response of UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");

		} catch (Exception e) {
			userRespVO.setMessageId(GenericCode.ERROR);
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error("		 Error while Authenticate User of UserName :: " + userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

	/**
	 * used to create New User
	 * 
	 * @param userReqVO
	 * @return UserRespVO
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody UserRespVO createUser(@RequestBody GenericReqVO genericReqVO) {
		final UserReqVO userReqVO = genericReqVO.getUserReqVO();
		UserRespVO userRespVO = new UserRespVO();
		try {
			logger.info("******************************************************************************");
			logger.info("        Create User Request from UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");

			userRespVO = userService.createUser(userReqVO);

			logger.info("******************************************************************************");
			logger.info("      Sent Create User Response of UserName ::  " + userReqVO.getUserName());
			logger.info("******************************************************************************");
		} catch (Exception e) {
			userRespVO.setMessageId(GenericCode.ERROR);
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error("		 Error while Create User of UserName :: " + userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

	/**
	 * used to create New User
	 * 
	 * @param userReqVO
	 * @return UserRespVO
	 */
	@RequestMapping(value = "/signOutUser", method = RequestMethod.POST)
	public @ResponseBody UserRespVO signOutUser(@RequestBody GenericReqVO genericReqVO) {
		final UserReqVO userReqVO = genericReqVO.getUserReqVO();
		UserRespVO userRespVO = new UserRespVO();
		try {
			logger.info("******************************************************************************");
			logger.info("        SignOut User Request from UserName ::  ");
			logger.info("******************************************************************************");

			logger.info("******************************************************************************");
			// logger.info(" Sent SignOut User Response of UserName :: " +
			// userReqVO.getUserName());
			logger.info("******************************************************************************");
		} catch (Exception e) {
			userRespVO.setMessageId(GenericCode.PROFILE_IMG_UPLOAD_FAILED);
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error(" 		Error while SignOut User of UserName :: " + userReqVO.getUserName());
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

	/**
	 * used to Upload Usesr's Profile Image
	 * 
	 * @param multipartFile
	 * @param userName
	 * @return UserRespVO
	 */
	@RequestMapping(value = "/uploadProfileImage", method = RequestMethod.POST)
	public @ResponseBody UserRespVO uploadProfileImage(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("userName") String userName) {

		UserRespVO userRespVO = new UserRespVO();
		try {
			logger.info("******************************************************************************");
			logger.info("        Upload User's Profile Image Request from UserName ::  ");
			logger.info("******************************************************************************");

			final String fileName = multipartFile.getOriginalFilename();
			final String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			final String userFileName = RandomStringUtils.randomAlphanumeric(32) + "." + extension;
			if (!multipartFile.isEmpty()) {
				// store Cropped Image file in storage
				multipartFile.transferTo(new File(configProperties.getProperty("profileImgSrc") + userFileName));

			}

			// Save User profileImage Name
			final UserReqVO userReqVO = new UserReqVO();
			userReqVO.setUserName(userName);
			userReqVO.setProfileImage(userFileName);
			userRespVO = userService.updateUser(userReqVO);

			logger.info("******************************************************************************");
			logger.info(" Sent Upload User's Profile Image Response of UserName :: " + userName);
			logger.info("******************************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("#############################################################################");
			logger.error("		Error while uploading User's Profile Image of UserName :: " + userName);
			logger.error("#############################################################################");
		}
		return userRespVO;
	}

}