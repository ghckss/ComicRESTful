package com.triangle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.triangle.domain.Criteria;
import com.triangle.domain.EpisodeVO;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.persistence.WebtoonDAO;

@Service
public class WebtoonServiceImpl implements WebtoonService {

	@Inject
	private WebtoonDAO dao;
	
	@Override
	public List<WebtoonVO> listWebtoon(Criteria cri) throws Exception{
		return dao.list(cri);
	}
	
	@Override
	public List<RelationshipVO> evaluationWebtoonList() throws Exception{
		return dao.evaluationList();
	}
	
	@Override
	public List<WebtoonVO> dailyToonList(WebtoonVO vo) throws Exception{
		return dao.selectDayToonList(vo);
	}
	
	@Override
	public List<EpisodeVO> getEpisodeList(WebtoonVO vo) throws Exception{
		return dao.selectEpisodeList(vo);
	}
	
	@Override
	public List<RelationshipVO> checkEpisode(WebtoonVO vo) throws Exception{
		return dao.checkEpisode(vo);
	}
}
