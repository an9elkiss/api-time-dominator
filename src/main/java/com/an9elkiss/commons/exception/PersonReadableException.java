package com.an9elkiss.commons.exception;

import com.an9elkiss.commons.command.ApiResponseCmd;
import com.an9elkiss.commons.command.Status;

public class PersonReadableException extends RuntimeException {

	private static final long serialVersionUID = 1678443936099209520L;

	private ApiResponseCmd<?> ApiResponseCmd = new ApiResponseCmd<Object>();

	public PersonReadableException() {
	}

	public PersonReadableException(Status status) {
		super(status.getMessage());
		ApiResponseCmd.setStatus(status);
	}

	public PersonReadableException(Status status, Throwable cause) {
		super(status.getMessage(), cause);
		ApiResponseCmd.setStatus(status);
	}

	public PersonReadableException(Status status, Object... params) {
		super(String.format(status.getMessage(), params));
		ApiResponseCmd.setStatus(status, params);
	}

	public PersonReadableException(Status status, Throwable cause, Object... params) {
		super(String.format(status.getMessage(), params), cause);
		ApiResponseCmd.setStatus(status, params);
	}

	public PersonReadableException(ApiResponseCmd<?> ApiResponseCmd) {
		super(ApiResponseCmd.getMessage());
		this.ApiResponseCmd = ApiResponseCmd;
	}

	public PersonReadableException(ApiResponseCmd<?> ApiResponseCmd, Throwable cause) {
		super(ApiResponseCmd.getMessage(), cause);
		this.ApiResponseCmd = ApiResponseCmd;
	}

	public PersonReadableException(String msg, ApiResponseCmd<?> ApiResponseCmd) {
		super(msg);
		this.ApiResponseCmd = ApiResponseCmd;
	}

	public PersonReadableException(String msg, ApiResponseCmd<?> ApiResponseCmd, Throwable cause) {
		super(msg, cause);
		this.ApiResponseCmd = ApiResponseCmd;
	}

	public ApiResponseCmd<?> getApiResponseCmd() {
		return ApiResponseCmd;
	}

}
