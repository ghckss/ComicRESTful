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

import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.service.RelationService;

@RestController
@RequestMapping("/mypage")
public class MypageController {
	
	@Inject
	private RelationService service; 
	
	
	@RequestMapping(value="/subscribe", method = RequestMethod.POST)
	public ResponseEntity<String> toonSubscribe(@RequestBody RelationshipVO vo){
		
		ResponseEntity<String> entity = null;
		try{
			int count = service.subscribeCount(vo);
			if(count == 0){
				service.toonSubscribe(vo);
			} else {
				service.subscribeDelete(vo);
			}
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/subscribe/list", method = RequestMethod.POST)
	public ResponseEntity<List<WebtoonVO>> getSubscribeList(@RequestBody WebtoonVO vo){
		
		ResponseEntity<List<WebtoonVO>> entity = null;
		try {
			System.out.println(service.getSubscribe(vo));
			entity = new ResponseEntity<>(service.getSubscribe(vo), HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/subscribe/check", method = RequestMethod.POST)
	public ResponseEntity<Integer> isSubscribed(@RequestBody RelationshipVO vo){
		
		ResponseEntity<Integer> entity = null;
		try {
			entity = new ResponseEntity<>(service.subscribeCount(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/recent", method = RequestMethod.POST)
	public ResponseEntity<List<WebtoonVO>> getRecentList(@RequestBody RelationshipVO vo){
		
		ResponseEntity<List<WebtoonVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listRecentToon(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}
