package com.triangle.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.domain.Criteria;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.service.RelationService;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Inject
	private RelationService service; 
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String> toonEvaluatePost(@RequestBody RelationshipVO vo){
		
		ResponseEntity<String> entity = null;
		try{
			if(service.listRating(vo).size() < 1){
				service.toonEvaluate(vo);
			} else{
				RelationshipVO dbInfo = (RelationshipVO) service.listRating(vo).get(0);
				if(dbInfo.getRating() == vo.getRating()){
					service.ratingDelete(vo);
				} else if(dbInfo.getRating() != vo.getRating()) {
					service.ratingUpdate(vo);
				}
			}
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public ResponseEntity<List<WebtoonVO>> evalWebtoonList(@RequestBody RelationshipVO vo){
		
		ResponseEntity<List<WebtoonVO>> entity = null;
		try{
			Criteria cri = new Criteria(vo.getNum(), 12);
			cri.setUserId(vo.getUserId());
			entity = new ResponseEntity<>(service.listRecommend(cri), HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/myeval", method = RequestMethod.POST)
	public ResponseEntity<List<RelationshipVO>> myevalList(@RequestBody RelationshipVO vo){
		
		ResponseEntity<List<RelationshipVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listRating(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
