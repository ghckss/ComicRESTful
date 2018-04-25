package com.triangle.persistence;

import java.util.List;

import com.triangle.domain.Criteria;
import com.triangle.domain.EpisodeVO;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;

public interface WebtoonDAO {

	public List<WebtoonVO> list(Criteria cri) throws Exception;
	
	public List<RelationshipVO> evaluationList() throws Exception;
	
	public List<WebtoonVO> selectDayToonList(WebtoonVO vo) throws Exception;
	
	public List<EpisodeVO> selectEpisodeList(WebtoonVO vo) throws Exception;
	
	public List<RelationshipVO> checkEpisode(WebtoonVO vo) throws Exception;
}
