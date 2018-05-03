package com.an9elkiss.commons.command;

import java.io.Serializable;

import com.an9elkiss.api.timedo.constant.ApiStatus;

public class ApiResponseCmd<T> implements Serializable{
	private static final long serialVersionUID = -2865055966239830849L;

	private Integer code;
	private String message;
	private T data;

	public ApiResponseCmd() {
	}

	public ApiResponseCmd(Status status) {
		setStatus(status);
	}

	public ApiResponseCmd(Status status, Object... params) {
		setStatus(status, params);
	}

	public static ApiResponseCmd success() {
		ApiResponseCmd apiResponseCmd = new ApiResponseCmd();
		apiResponseCmd.setStatus(ApiStatus.SUCCESS);
		return apiResponseCmd;
	}

	public void setStatus(Status status) {
		this.code = status.getCode();
		this.message = status.getMessage();
	}

	public void setStatus(Status status, Object... params) {
		this.code = status.getCode();
		this.message = String.format(status.getMessage(), params);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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


}
