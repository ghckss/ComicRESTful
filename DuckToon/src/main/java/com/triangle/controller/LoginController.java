package com.triangle.controller;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.triangle.domain.LoginVO;
import com.triangle.service.LoginService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Inject
	private LoginService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<LoginVO> getProfile(@RequestBody LoginVO vo){
		
		ResponseEntity<LoginVO> entity = null;
		
		String token = vo.getAccessToken();
		String header = "Bearer " + token;
		try{
			int count = service.checkUserExist(vo.getId());
			String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
			if(responseCode==200){            
				if(count == 1){
					service.changeState(vo);
				} else {
					service.addNewUser(vo);
				}
				entity = new ResponseEntity<LoginVO>(vo, HttpStatus.OK);
				System.out.println("true");
			} else {						
				System.out.println("false");
			}
		} catch (Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<LoginVO>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}