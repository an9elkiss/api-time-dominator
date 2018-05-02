package com.an9elkiss.api.timedo.service;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an9elkiss.api.timedo.command.TimeEntryCmd;
import com.an9elkiss.api.timedo.dao.TimeEntryDao;
import com.an9elkiss.api.timedo.model.TimeEntry;
import com.an9elkiss.commons.command.ApiResponseCmd;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {

	private final Logger logger = LoggerFactory.getLogger(TimeEntryServiceImpl.class);

	@Autowired
	private TimeEntryDao timeEntryDao;

	@Override
	public ApiResponseCmd<Object> createTimeEntry(TimeEntryCmd timeEntryCmd) {
		// TODO command数据校验目前由swagger api来控制

		TimeEntry timeEntry = new TimeEntry();
		try {
			BeanUtils.copyProperties(timeEntry, timeEntryCmd);
		} catch (Exception e) {

			// TODO Auto-generated catch block
					e.printStackTrace();
		}

		timeEntryDao.save(timeEntry);

		return null;
	}

}
