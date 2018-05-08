/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12-1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.an9elkiss.api.timedo.api;

import org.springframework.http.ResponseEntity;

import com.an9elkiss.api.timedo.command.WeekDaysCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "com.an9elkiss.codegen.languages.SpringCodegen", date = "2018-05-08T02:55:16.649Z")

@Api(value = "week-days", description = "the week-days API")
public interface WeekDaysApi {

	@ApiOperation(value = "Get daily status of the current week", nickname = "getWeekDays", notes = "", response = WeekDaysCmd.class, tags = {
			"time-entry", })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "successful operation", response = WeekDaysCmd.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied") })
	ResponseEntity<ApiResponseCmd<WeekDaysCmd>> getWeekDays();

}