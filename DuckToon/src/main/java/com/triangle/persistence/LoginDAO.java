package com.triangle.persistence;

import com.triangle.domain.LoginVO;

public interface LoginDAO {

	public void newUser(LoginVO vo) throws Exception;
	
	public Integer isUserExist(String accessToken) throws Exception;
	
	public void updateState(LoginVO vo) throws Exception;
}
