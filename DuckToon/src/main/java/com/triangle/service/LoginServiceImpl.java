package com.triangle.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.triangle.domain.LoginVO;
import com.triangle.persistence.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO dao;
	
	@Override
	public void addNewUser(LoginVO vo) throws Exception{
		dao.newUser(vo);
	}
	
	@Override
	public Integer checkUserExist(String id) throws Exception{
		return dao.isUserExist(id);
	}
	
	@Override
	public void changeState(LoginVO vo) throws Exception{
		dao.updateState(vo);
	}
}
