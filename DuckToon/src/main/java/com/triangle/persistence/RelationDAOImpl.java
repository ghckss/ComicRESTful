package com.triangle.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.triangle.domain.Criteria;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

@Repository
public class RelationDAOImpl implements RelationDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.triangle.mapper.RelationMapper";
	
	@Override
	public List selectRatingInfo(RelationshipVO vo) throws Exception{
		return session.selectList(namespace + ".myevalList", vo);
	}
	
	@Override
	public void insertEvaluate(RelationshipVO vo) throws Exception{
		session.insert(namespace + ".evaluateToon", vo);
	}
	
	@Override
	public void updateRating(RelationshipVO vo) throws Exception{
		session.update(namespace + ".updateRating", vo);
	}
	
	@Override
	public void deleteRating(RelationshipVO vo) throws Exception{
		session.update(namespace + ".deleteRating", vo);
	}
	
	@Override
	public List selectSubscribe(WebtoonVO vo) throws Exception{
		return session.selectList(namespace + ".getSubscribe", vo);
	}
	
	@Override
	public void subscribeToon(RelationshipVO vo) throws Exception{
		session.insert(namespace + ".subscribe", vo);
	}
	
	@Override
	public void deleteSubscribe(RelationshipVO vo) throws Exception{
		session.delete(namespace + ".deleteSubscribe", vo);
	}
	
	@Override
	public List selectRecommendList(Criteria cri) throws Exception{
		return session.selectList(namespace + ".recommendList", cri);
	}
	
	@Override
	public Integer countSubscribe(RelationshipVO vo) throws Exception{
		return session.selectOne(namespace + ".isSubscribe", vo);
	}
	
	@Override
	public List selectRecentToon(RelationshipVO vo) throws Exception{
		return session.selectList(namespace + ".recentWebtoon", vo);
	}
	
	@Override
	public List selectReviewInfo(RelationshipVO vo) throws Exception{
		return session.selectList(namespace + ".reviewInfo", vo);
	}
	
	@Override
	public List selectSearchList(String word) throws Exception {
		return session.selectList(namespace + ".searchResult", word);
	}
	
}
