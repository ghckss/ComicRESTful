package com.triangle.persistence;

import java.util.List;

import com.triangle.domain.Criteria;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

public interface RelationDAO {

	public List selectRatingInfo(RelationshipVO vo) throws Exception;
	
	public void insertEvaluate(RelationshipVO vo) throws Exception;
	
	public void updateRating(RelationshipVO vo) throws Exception;
	
	public void deleteRating(RelationshipVO vo) throws Exception;
	
	public List selectSubscribe(WebtoonVO vo) throws Exception;
	
	public void subscribeToon(RelationshipVO vo) throws Exception;
	
	public void deleteSubscribe(RelationshipVO vo) throws Exception;
	
	public List selectRecommendList(Criteria cri) throws Exception;
	
	public Integer countSubscribe(RelationshipVO vo) throws Exception;
	
	public List selectRecentToon(RelationshipVO vo) throws Exception;
	
	public List selectReviewInfo(RelationshipVO vo) throws Exception;
	
	public List selectSearchList(String word) throws Exception;
}
