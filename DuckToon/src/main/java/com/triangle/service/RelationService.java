package com.triangle.service;

import java.util.List;

import com.triangle.domain.Criteria;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

public interface RelationService {
	
	public List listRating(RelationshipVO vo) throws Exception;
	
	public void toonEvaluate(RelationshipVO vo) throws Exception;
	
	public void ratingUpdate(RelationshipVO vo) throws Exception;
	
	public void ratingDelete(RelationshipVO vo) throws Exception;
	
	public List getSubscribe(WebtoonVO vo) throws Exception;
	
	public void toonSubscribe(RelationshipVO vo) throws Exception;
	
	public void subscribeDelete(RelationshipVO vo) throws Exception;
	
	public List listRecommend(Criteria cri) throws Exception;
	
	public Integer subscribeCount(RelationshipVO vo) throws Exception;
	
	public List listRecentToon(RelationshipVO vo) throws Exception;
	
	public List listReviewInfo(RelationshipVO vo) throws Exception;
	
	public List listSearchItems(String word) throws Exception;
}
