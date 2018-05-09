package com.an9elkiss.api.timedo.command;

import java.util.Date;

import com.an9elkiss.api.timedo.constant.TimeEntryType;


public class TimeEntryCmd   {

	private Integer id;
	private Date date;
	private Integer typeId;
	private String typeName;
	private String comment;
	private Integer duration;

	public TimeEntryCmd() {
	}

	public TimeEntryCmd(TimeEntryType type) {
		this.typeId = type.getTypeId();
		this.typeName = type.getTypeName();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}

