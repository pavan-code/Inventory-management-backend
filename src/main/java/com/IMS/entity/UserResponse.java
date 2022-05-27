package com.IMS.entity;

import java.util.List;

public class UserResponse<T> {

	private boolean status;
	private int statusCode;
	private String message;
	private T data;
	private List<T> datae;
	
	public UserResponse(boolean status, int statusCode, String message, T data, List<T> datae) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
		this.datae = datae;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getDatae() {
		return datae;
	}
	public void setDatae(List<T> datae) {
		this.datae = datae;
	}
}
