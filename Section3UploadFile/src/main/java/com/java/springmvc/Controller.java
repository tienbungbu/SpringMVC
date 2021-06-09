package com.java.springmvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping(value = "/upload-file", method = RequestMethod.GET)	
	public String uploadFile(HttpServletRequest req) {
		
		
		return "uploadFile";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)	
	public String uploadFile(HttpServletRequest req, @RequestParam(name = "file") MultipartFile file) {
		//luu xuong o cung
		try {
			File saveFile = new File("E:\\SaveFile\\" + file.getOriginalFilename()); 
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(saveFile);
			
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// da luu xuong o cung
		
		req.setAttribute("file", file);
		return "viewFile";
	}
	
	@RequestMapping(value = "/download-file", method = RequestMethod.GET)	
	public void  downloadFile(HttpServletRequest req, HttpServletResponse resp) {
		String dataDirectory = "E:\\SaveFile\\";
		Path file = Paths.get(dataDirectory, "1.docx");
		if(Files.exists(file)){
			resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
			resp.addHeader("Content-Disposition", "attachment; filename=chuyende.docx" );
			
			try {
				Files.copy(file, resp.getOutputStream());
				resp.getOutputStream().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
