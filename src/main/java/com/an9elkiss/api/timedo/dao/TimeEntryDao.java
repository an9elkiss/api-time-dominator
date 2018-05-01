package com.an9elkiss.api.timedo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.an9elkiss.api.timedo.model.TimeEntry;

@Mapper
public interface TimeEntryDao {

	int save(TimeEntry timeEntry);

	int update(TimeEntry timeEntry);

}
