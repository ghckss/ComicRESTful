package com.triangle.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.domain.RelationshipVO;
import com.triangle.domain.WebtoonVO;
import com.triangle.service.RelationService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Inject
	private RelationService service;
	
	@RequestMapping(value="/{word}", method=RequestMethod.GET)
	public ResponseEntity<List<WebtoonVO>> searchList(@PathVariable("word") String word) {
		ResponseEntity<List<WebtoonVO>> entity = null;
		try {
			entity = new ResponseEntity<List<WebtoonVO>>(service.listSearchItems(word), HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
