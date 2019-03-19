package com.showcase.books.response;

public class UploadFileResponse {

    private String fileName;
    private Integer statusCode;
	
    public UploadFileResponse() {
		super();
	}

	public UploadFileResponse(String fileName, Integer statusCode) {
		super();
		this.fileName = fileName;
		this.statusCode = statusCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
    
    
	
}
