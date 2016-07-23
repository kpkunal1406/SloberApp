/**
 * 
 */
package com.slober.integration.user.service;

import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 */
public interface UserIntegrationService {
	public UserRespVO authenticateUserIntegration(UserReqVO userReqVO) throws Exception;

	public UserRespVO createUserIntegration(UserReqVO userReqVO) throws Exception;
}
