package com.phearun.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService{

	public String upload(MultipartFile file, String folder, HttpServletRequest request) {
		
		String PROJECT_PATH = "/resources/images/";
		
		String SERVER_PATH = request.getServletContext().getRealPath("/resources/images/");
		System.out.println(SERVER_PATH);
		
		if(file == null){
			System.out.println("File is empty!");
			System.out.println("File is not present! Please choose file to upload!!!");
			
		}else{
			if(folder=="" || folder==null)
				folder = "default";
			
			String UPLOAD_PATH = SERVER_PATH + folder;
			
			java.io.File path = new java.io.File(UPLOAD_PATH);
			if(!path.exists())
				path.mkdirs();
			
			String fileName = file.getOriginalFilename();
			fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			try {
				Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
			} catch (Exception e) { 
				System.out.println("Fail to upload!, " + e.getMessage());
			}				
				
			return PROJECT_PATH + folder + "/" + fileName; 
		}
		
		//default image
		return "/resources/admin/images/user.png";
	}

	
}

