package com.triangle.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.triangle.domain.RelationshipVO;
import com.triangle.service.RelationService;

@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Inject
	private RelationService service; 
	
	@RequestMapping(value="/review", method=RequestMethod.POST)
	public ResponseEntity<List<RelationshipVO>> reviewInfo(@RequestBody RelationshipVO vo) {
		ResponseEntity<List<RelationshipVO>> entity = null;
		try{
			entity = new ResponseEntity<>(service.listReviewInfo(vo), HttpStatus.OK);
		} catch(Exception e){
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/images", headers = ("content-type=multipart/*" ), method=RequestMethod.POST)
	public void downloadImage(@RequestParam("file") MultipartFile report, @RequestParam("place") String place){
		InputStreamReader inputStreamReader = null;
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		System.out.println(report.getOriginalFilename());
		System.out.println(place);
		try {
			System.out.println("파일전송 시작");
			inputStream = report.getInputStream();
			//fileOutputStream = new FileOutputStream("/home/hosting_users/ghckss/www/resources/"+place+"/"+report.getOriginalFilename());
			fileOutputStream = new FileOutputStream("D:\\workspace/DuckToon/src/main/webapp/resources/"+place+"/"+report.getOriginalFilename());
			byte[] dataBuff = new byte[10000];
			int length = inputStream.read(dataBuff);
			while (length != -1) {
				System.out.print(".");
				fileOutputStream.write(dataBuff, 0, length);
				length = inputStream.read(dataBuff);
			}
			System.out.println("파일전송 끝");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
