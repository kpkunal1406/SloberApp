/**
 * 
 */
package com.slober.integration.dto;

import org.springframework.stereotype.Component;

import com.slober.integration.entity.SlbUser;
import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 */
@Component
public class UserDTO {
	/**
	 * 
	 * @param slbUser
	 * @return UserRespVO
	 */
	public UserRespVO slbUSerToUserRespVO(SlbUser slbUser) {
		final UserRespVO userRespVO = new UserRespVO();
		if (slbUser != null) {
			userRespVO.setProfileName(slbUser.getFirstname() + " " + slbUser.getLastname());
			userRespVO.setUserName(slbUser.getUsername());
			userRespVO.setEmail(slbUser.getEmail());
			userRespVO.setFirstName(slbUser.getFirstname());
			userRespVO.setLastName(slbUser.getLastname());
			userRespVO.setProfileImage(slbUser.getProfileImage());
		}
		return userRespVO;
	}

	/**
	 * 
	 * @param userReqVO
	 * @return SlbUser
	 */
	public SlbUser UserReqVOToSlbUser(UserReqVO userReqVO) {
		final SlbUser slbUser = new SlbUser();
		if (userReqVO != null) {
			slbUser.setEmail(userReqVO.getEmail());
			slbUser.setFirstname(userReqVO.getFirstName());
			slbUser.setLastname(userReqVO.getLastName());
			slbUser.setUsername(userReqVO.getUserName());
			slbUser.setPassword(userReqVO.getPassword());
			slbUser.setProfileImage(userReqVO.getProfileImage());
		}
		return slbUser;
	}

	public SlbUser setUpdatedValues(SlbUser slbUser, UserReqVO userReqVO) {
		if (userReqVO != null) {
			if (userReqVO.getEmail() != null) {
				slbUser.setEmail(userReqVO.getEmail());
			}
			if (userReqVO.getFirstName() != null) {
				slbUser.setFirstname(userReqVO.getFirstName());
			}
			if (userReqVO.getLastName() != null) {
				slbUser.setLastname(userReqVO.getLastName());
			}
			if (userReqVO.getPassword() != null) {
				slbUser.setPassword(userReqVO.getPassword());
			}
			if (userReqVO.getUserName() != null) {
				slbUser.setUsername(userReqVO.getUserName());
			}
			if (userReqVO.getProfileImage() != null) {
				slbUser.setProfileImage(userReqVO.getProfileImage());
			}
		}

		return slbUser;
	}
}
