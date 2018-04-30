package com.an9elkiss.api.timedo.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.threeten.bp.OffsetDateTime;

import com.an9elkiss.api.timedo.model.TimeEntry;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-28T09:59:07.066Z")

@Controller
public class TimeEntryApiController implements TimeEntryApi {

    private static final Logger log = LoggerFactory.getLogger(TimeEntryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TimeEntryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
	public ResponseEntity<Void> addTimeEntry(@ApiParam(value = "Date of the time entry", required=true) @RequestPart(value="date", required=true)  OffsetDateTime date,@ApiParam(value = "Type of time entry", required=true) @RequestPart(value="type", required=true)  String type,@ApiParam(value = "Duration of time entry", required=true) @RequestPart(value="duration", required=true)  Long duration,@ApiParam(value = "Comment of time entry") @RequestPart(value="comment", required=false)  String comment) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<Void> deleteTimeEntry(@ApiParam(value = "Time entry id to delete",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<TimeEntry> findPetById(@ApiParam(value = "ID of time entry that needs to be fetched",required=true) @PathVariable("id") Long id) {
            try {
                return new ResponseEntity<TimeEntry>(objectMapper.readValue("{  \"date\" : \"2000-01-23T04:56:07.000+00:00\",  \"duration\" : 0,  \"comment\" : \"learn AI\",  \"type\" : \"it-learning\"}", TimeEntry.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TimeEntry>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @Override
	public ResponseEntity<Void> updateTimeEntry(@ApiParam(value = "ID of time entry that needs to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Updated date of the time entry", required=true) @RequestPart(value="date", required=true)  OffsetDateTime date,@ApiParam(value = "Updated type of time entry", required=true) @RequestPart(value="type", required=true)  String type,@ApiParam(value = "Updated duration of time entry", required=true) @RequestPart(value="duration", required=true)  Long duration,@ApiParam(value = "Updated comment of time entry") @RequestPart(value="comment", required=false)  String comment) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
