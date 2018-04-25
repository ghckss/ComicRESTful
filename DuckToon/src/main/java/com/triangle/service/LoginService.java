package com.triangle.service;

import java.util.List;

import com.triangle.domain.LoginVO;

public interface LoginService {

	public void addNewUser(LoginVO vo) throws Exception;
	
	public Integer checkUserExist(String accessToken) throws Exception;
	
	public void changeState(LoginVO vo) throws Exception;
}
