package com.triangle.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.triangle.domain.Criteria;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.persistence.RelationDAO;

@Service
public class RelationServiceImpl implements RelationService{

	@Inject
	private RelationDAO dao;
	
	@Override
	public List listRating(RelationshipVO vo) throws Exception{
		return dao.selectRatingInfo(vo);
	}
	
	@Override
	public void toonEvaluate(RelationshipVO vo) throws Exception{
		dao.insertEvaluate(vo);
	}
	
	@Override
	public void ratingUpdate(RelationshipVO vo) throws Exception{
		dao.updateRating(vo);
	}
	
	@Override
	public void ratingDelete(RelationshipVO vo) throws Exception{
		dao.deleteRating(vo);
	}
	
	@Override
	public List getSubscribe(WebtoonVO vo) throws Exception{
		return dao.selectSubscribe(vo);
	}
	
	@Override
	public void toonSubscribe(RelationshipVO vo) throws Exception{
		dao.subscribeToon(vo);
	}
	
	@Override
	public void subscribeDelete(RelationshipVO vo) throws Exception{
		dao.deleteSubscribe(vo);
	}
	
	@Override
	public List listRecommend(Criteria cri) throws Exception{
		return dao.selectRecommendList(cri);
	}
	
	@Override
	public Integer subscribeCount(RelationshipVO vo) throws Exception{
		return dao.countSubscribe(vo);
	}
	
	@Override
	public List listRecentToon(RelationshipVO vo) throws Exception{
		return dao.selectRecentToon(vo);
	}
	
	@Override
	public List listReviewInfo(RelationshipVO vo) throws Exception{
		return dao.selectReviewInfo(vo);
	}
	
	@Override
	public List listSearchItems(String word) throws Exception {
		return dao.selectSearchList(word);
	}
}
