package com.library.dto.response;

import com.library.entity.book;

public class ResponseMessage {
    private String message;
    private book book;

    public ResponseMessage() {
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, book book) {
    	this.message = message;
    	this.setBook(book);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public book getBook() {
		return book;
	}

	public void setBook(book book) {
		this.book = book;
	}
}
