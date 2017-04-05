package com.phearun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.phearun.service.UploadService;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public String upload(@RequestParam("photo") MultipartFile file,
			@RequestParam(value = "folder", required = false) String folder,
			HttpServletRequest request){

		System.out.println("File: " + file.getOriginalFilename());
		return uploadService.upload(file, folder, request);
	}
	
	
}
