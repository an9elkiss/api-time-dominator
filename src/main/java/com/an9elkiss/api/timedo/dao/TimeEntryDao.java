package com.an9elkiss.api.timedo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.an9elkiss.api.timedo.model.TimeEntry;

@Mapper
public interface TimeEntryDao {

	// @Insert(
	// "insert into t_time_entry"+
	// "(date, type_id, comment, duration, status, create_by, update_by)"+
	// "values"+
	// "(#{date}, #{typeId}, #{comment}, #{duration}, #{status}, #{createBy},
	// #{createBy});"
	// )
	int save(TimeEntry timeEntry);

	int update(TimeEntry timeEntry);

}
