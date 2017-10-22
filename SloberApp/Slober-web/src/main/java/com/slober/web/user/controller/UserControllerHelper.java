package com.slober.web.user.controller;

import org.springframework.stereotype.Component;

import com.slober.util.GenericCode;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 *         This UserControllerHelper class is used to manipulate response or
 *         request
 */
@Component
public class UserControllerHelper {

	protected UserRespVO getResponseOfAuthenticatUser(UserRespVO userRespVO) throws Exception {
		if (userRespVO.getUserName() == null) {
			userRespVO.setMessageId(GenericCode.AUTHENTICATION_FAILED);
		}
		return userRespVO;
	}
}
