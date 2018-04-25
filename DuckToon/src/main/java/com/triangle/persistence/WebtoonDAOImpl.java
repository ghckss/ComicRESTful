package com.triangle.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.triangle.domain.Criteria;
import com.triangle.domain.EpisodeVO;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

@Repository
public class WebtoonDAOImpl implements WebtoonDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.triangle.mapper.WebtoonMapper";
	
	@Override
	public List<WebtoonVO> list(Criteria cri) throws Exception{
		return session.selectList(namespace+".list", cri);
	}
	
	@Override
	public List<RelationshipVO> evaluationList() throws Exception{
		return session.selectList(namespace+".evaluateList");
	}
	
	@Override
	public List<WebtoonVO> selectDayToonList(WebtoonVO vo) throws Exception{
		return session.selectList(namespace+".dayWebtoonList", vo);
	}
	
	@Override
	public List<EpisodeVO> selectEpisodeList(WebtoonVO vo) throws Exception{
		return session.selectList(namespace+".episodeList", vo);
	}
	
	@Override
	public List<RelationshipVO> checkEpisode(WebtoonVO vo) throws Exception{
		return session.selectList(namespace+".checkEpisode", vo);
	}
	
}
