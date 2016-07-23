/**
 * 
 */
package com.slober.web.user.service;

import com.slober.util.model.req.UserReqVO;
import com.slober.util.model.resp.UserRespVO;

/**
 * @author Kunal
 *
 */
public interface UserService {
	public UserRespVO authenticateUser(UserReqVO userReqVO) throws Exception;

	public UserRespVO createUser(UserReqVO userReqVO) throws Exception;
}
