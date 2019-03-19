package com.showcase.books.rest.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.showcase.books.response.UploadFileResponse;


@RestController
@CrossOrigin
public class RestUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestUploadController.class);
	
	@RequestMapping(value="/uploadBookImage", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile fileUpload) throws IOException {
		
		logger.info("[RestUploadController][uploadFile][INICIO]");
		
		String originalFilename = fileUpload.getOriginalFilename();
		logger.info("[RestUploadController][uploadFile][originalFilename: " + originalFilename  + "]");
		
		File convertFile = new File("/var/www/html/images-test/" + originalFilename);
		boolean createNewFile = convertFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convertFile);
		fos.write(fileUpload.getBytes());
		
		UploadFileResponse uploadFileResponse = new UploadFileResponse(originalFilename, 200);
		
		logger.info("[RestUploadController][uploadFile][FIN]");
		
		return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(uploadFileResponse);
	}
	
}
