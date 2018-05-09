package com.an9elkiss.api.timedo.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.an9elkiss.api.timedo.command.TimeEntriesCmd;
import com.an9elkiss.api.timedo.service.TimeEntryService;
import com.an9elkiss.commons.command.ApiResponseCmd;
import com.an9elkiss.commons.util.MapUtils;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-28T09:59:07.066Z")

@Controller
public class TimeEntriesApiController implements TimeEntriesApi {

    private static final Logger log = LoggerFactory.getLogger(TimeEntriesApiController.class);

	@Autowired
	private TimeEntryService timeEntryService;

    @Override
	@RequestMapping(value = "/time-entries/daily", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<ApiResponseCmd<TimeEntriesCmd>> findDailyTimeEntries(
			@ApiParam(value = "Query param") @Valid @RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {

		ApiResponseCmd<TimeEntriesCmd> cmd = timeEntryService.findDailyTimeEntries(date);

		return ResponseEntity.ok(cmd);
	}

	@Override
	@RequestMapping(value = "/time-entries", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<ApiResponseCmd<TimeEntriesCmd>> findTimeEntries(
			@ApiParam(value = "Query param") @Valid @RequestParam(value = "dateFrom", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateFrom,
			@ApiParam(value = "Query param") @Valid @RequestParam(value = "dateTo", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateTo,
			@ApiParam(value = "Query param") @Valid @RequestParam(value = "typeId", required = false) Integer typeId) {

		Map<String, Object> searchParams = new HashMap<String, Object>();
		MapUtils.addIfNotBlank(searchParams, "dateFrom", dateFrom);
		MapUtils.addIfNotBlank(searchParams, "dateTo", dateTo);
		MapUtils.addIfNotBlank(searchParams, "typeId", typeId);

		// TODO 控制查询结果数量

		ApiResponseCmd<TimeEntriesCmd> cmd = timeEntryService.findTimeEntries(searchParams);

		return ResponseEntity.ok(cmd);
    }

}
