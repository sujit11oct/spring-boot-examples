package com.sujitkumar.springbootgif.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	
//	@Value("$spring.servlet.multipart.location")
//	private String location;
	private String location="/tmp/temp_video";
	@RequestMapping(value="/upload",method=RequestMethod.POST,
			produces=MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestPart("file") MultipartFile file,
						 @RequestParam("start") int start,
						 @RequestParam("end") int end,
						 @RequestParam("speed") int speed,
						 @RequestParam("repeat") boolean repeat
						) throws IllegalStateException, IOException {
		System.out.println("location:"+location);
		File videoFile=new File(location+"/"+System.currentTimeMillis()+".mp4");
		file.transferTo(videoFile);
		log.info("Save file to {}"+videoFile.getAbsolutePath());
		
		
		
		return "";
		
	}
	

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
