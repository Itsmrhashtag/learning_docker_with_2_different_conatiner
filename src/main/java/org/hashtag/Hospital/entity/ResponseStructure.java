package org.hashtag.Hospital.entity;

public class ResponseStructure<T> {

	private int statusCode;
	private T data;
	private String mess;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public ResponseStructure(int statusCode, T data, String mess) {
		this.statusCode = statusCode;
		this.data = data;
		this.mess = mess;
	}
//	public ResponseStructure(int value, Hospital hs, String mess2) {
//		// TODO Auto-generated constructor stub
//	}
	
}
