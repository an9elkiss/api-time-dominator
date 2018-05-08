package com.an9elkiss.api.timedo.command;

import com.an9elkiss.commons.util.JsonUtils;

public class DailyStatusCmd   {

	public static final Integer DONE = 1;
	public static final Integer TODAY = 2;
	public static final Integer FUTURE = 3;
	public static final Integer UNDO = 4;

	private Integer date;
	private Integer type;

	public DailyStatusCmd(Integer date, Integer type) {
		this.date = date;
		this.type = type;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}

}

