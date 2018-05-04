package com.an9elkiss.api.timedo.service;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.an9elkiss.api.timedo.command.TimeEntryCmd;
import com.an9elkiss.api.timedo.constant.ApiStatus;
import com.an9elkiss.api.timedo.dao.TimeEntryDao;
import com.an9elkiss.api.timedo.exception.TimedoBizException;
import com.an9elkiss.api.timedo.model.TimeEntry;
import com.an9elkiss.commons.auth.AppContext;
import com.an9elkiss.commons.command.ApiResponseCmd;
import com.an9elkiss.commons.util.JsonUtils;

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
			throw new TimedoBizException("TimeEntryCmd 转 TimeEntry 出错！", e);
		}
		timeEntry.setStatus(ApiStatus.NEW.getCode());
		timeEntry.setCreateBy(AppContext.getPrincipal().getName());

		int i = timeEntryDao.save(timeEntry);
		if (i != 1) {
			throw new TimedoBizException("新建 TimeEntry 失败！" + JsonUtils.toString(timeEntry));
		}

		return ApiResponseCmd.success();
	}

	@Override
	public ApiResponseCmd<Object> deleteTimeEntry(Integer id) {
		// TODO 入参校验目前由swagger api来控制

		timeEntryDao.delete(id);

		return ApiResponseCmd.success();
	}

	@Override
	public ApiResponseCmd<TimeEntryCmd> findById(Integer id) {
		// TODO 入参校验目前由swagger api来控制

		TimeEntryCmd timeEntryCmd = timeEntryDao.findById(id);

		if (timeEntryCmd != null && timeEntryCmd.getId() != null) {
			return ApiResponseCmd.success(timeEntryCmd);
		}

		ApiResponseCmd apiResponseCmd = new ApiResponseCmd();
		apiResponseCmd.setStatus(ApiStatus.NOT_FOUND);
		return apiResponseCmd;
	}

	@Override
	@Transactional
	public ApiResponseCmd<TimeEntryCmd> updateTimeEntry(TimeEntryCmd timeEntryCmd) {
		// TODO command数据校验目前由swagger api来控制

		TimeEntry timeEntry = new TimeEntry();
		try {
			BeanUtils.copyProperties(timeEntry, timeEntryCmd);
		} catch (Exception e) {
			throw new TimedoBizException("TimeEntryCmd 转 TimeEntry 出错！", e);
		}
		timeEntry.setUpdateBy(AppContext.getPrincipal().getName());

		int i = timeEntryDao.update(timeEntry);
		if (i < 1) {
			ApiResponseCmd apiResponseCmd = new ApiResponseCmd();
			apiResponseCmd.setStatus(ApiStatus.NOT_FOUND);
			return apiResponseCmd;
		}

		TimeEntryCmd timeEntryRecord = timeEntryDao.findById(timeEntryCmd.getId());
		return ApiResponseCmd.success(timeEntryRecord);
	}

}
