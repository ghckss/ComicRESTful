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

import com.triangle.domain.EpisodeVO;
import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.service.WebtoonService;

@RestController
@RequestMapping("/webtoon")
public class WebtoonController {

	@Inject
	private WebtoonService service;
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResponseEntity<List<WebtoonVO>> dayList(@RequestBody WebtoonVO vo){
		ResponseEntity<List<WebtoonVO>> entity = null;
		try {
			entity = new ResponseEntity<List<WebtoonVO>>(service.dailyToonList(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/episode", method=RequestMethod.POST)
	public ResponseEntity<List<EpisodeVO>> episodeList(@RequestBody WebtoonVO vo) {
		ResponseEntity<List<EpisodeVO>> entity = null;
		try {
			entity = new ResponseEntity<List<EpisodeVO>>(service.getEpisodeList(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/episode/check", method=RequestMethod.POST)
	public ResponseEntity<List<RelationshipVO>> checkEpisodeList(@RequestBody WebtoonVO vo) {
		ResponseEntity<List<RelationshipVO>> entity = null;
		try {
			entity = new ResponseEntity<List<RelationshipVO>>(service.checkEpisode(vo), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
