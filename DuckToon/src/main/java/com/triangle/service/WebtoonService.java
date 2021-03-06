package com.triangle.service;

import java.util.List;

import com.triangle.domain.Criteria;
import com.triangle.domain.EpisodeVO;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

public interface WebtoonService {

	public List<WebtoonVO> listWebtoon(Criteria cri) throws Exception;
	
	public List<RelationshipVO> evaluationWebtoonList() throws Exception;
	
	public List<WebtoonVO> dailyToonList(WebtoonVO vo) throws Exception;
	
	public List<EpisodeVO> getEpisodeList(WebtoonVO vo) throws Exception;
	
	public List<RelationshipVO> checkEpisode(WebtoonVO vo) throws Exception;
}
