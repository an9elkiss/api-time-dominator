package com.an9elkiss.api.timedo.service;

import java.util.Date;
import java.util.Map;

import com.an9elkiss.api.timedo.command.TimeEntriesCmd;
import com.an9elkiss.api.timedo.command.TimeEntryCmd;
import com.an9elkiss.api.timedo.command.WeekDaysCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

public interface TimeEntryService {

	ApiResponseCmd<Object> createTimeEntry(TimeEntryCmd timeEntryCmd);

	ApiResponseCmd<Object> deleteTimeEntry(Integer id);

	ApiResponseCmd<TimeEntryCmd> findById(Integer id);

	ApiResponseCmd<TimeEntryCmd> updateTimeEntry(TimeEntryCmd timeEntryCmd);

	ApiResponseCmd<WeekDaysCmd> getWeekDays();

	ApiResponseCmd<TimeEntriesCmd> findTimeEntries(Map<String, ?> searchParams);

	ApiResponseCmd<TimeEntriesCmd> findDailyTimeEntries(Date date);

}
