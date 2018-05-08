package com.an9elkiss.api.timedo.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.an9elkiss.api.timedo.command.TimeEntryCmd;
import com.an9elkiss.api.timedo.model.TimeEntry;

@Mapper
public interface TimeEntryDao {

	int save(TimeEntry timeEntry);

	int update(TimeEntry timeEntry);

	int delete(Integer id);

	TimeEntryCmd findById(Integer id);

	Integer sumDurationOfDay(Date date);

}
