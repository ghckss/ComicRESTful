package com.triangle.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.domain.RelationshipVO;
import com.triangle.service.WebtoonService;
import com.triangle.utils.CollabFilter;

@RestController
@RequestMapping("recommend")
public class RecommendController {
	
	@Inject
	private WebtoonService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<RelationshipVO>> list(){
		ResponseEntity<List<RelationshipVO>> entity = null;
		try{
			String id = "1";
			String webtoon = "39af8d4b-3fc4-4d42-a687-20374b2cc0f9";
			CollabFilter cf = new CollabFilter(service.evaluationWebtoonList(), id, webtoon, 5);
			cf.initialize();
			List k_nearest_neighbors = cf.k_nearest_neighbors(id, 5);
			double prediction = cf.predict(webtoon, k_nearest_neighbors);
			cf.display(k_nearest_neighbors, prediction);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
}
