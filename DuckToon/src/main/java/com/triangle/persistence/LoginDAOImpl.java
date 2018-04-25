package com.triangle.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.triangle.domain.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.triangle.mapper.LoginMapper";
	
	@Override
	public void newUser(LoginVO vo) throws Exception{
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public Integer isUserExist(String id) throws Exception{
		return session.selectOne(namespace + ".user", id);
	}
	
	@Override
	public void updateState(LoginVO vo) throws Exception{
		session.update(namespace + ".changeState", vo);
	}
}
