package com.an9elkiss.api.timedo.service;

import com.an9elkiss.api.timedo.command.TimeEntryCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

public interface TimeEntryService {

	ApiResponseCmd<Object> createTimeEntry(TimeEntryCmd timeEntryCmd);

	ApiResponseCmd<Object> deleteTimeEntry(Integer id);

	ApiResponseCmd<TimeEntryCmd> findById(Integer id);

	ApiResponseCmd<TimeEntryCmd> updateTimeEntry(TimeEntryCmd timeEntryCmd);

}
