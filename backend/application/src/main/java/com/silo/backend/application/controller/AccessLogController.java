
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.AccessLog;
import com.silo.backend.service.AccessLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import java.util.List;


/**
 * REST controller for managing {@link AccessLog}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/accessLog")
public class AccessLogController {

    private final Logger log = LoggerFactory.getLogger(AccessLogController.class);
	
    private AccessLogService entityService;

    public AccessLogController (AccessLogService entityService) {
	}

    /**
     * {@code POST  /accessLog} : Create a new accessLog.
     *
     * @param accessLog the accessLog to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessLog.
     */
	@PostMapping()
	public ResponseEntity<AccessLog> createAccessLog(@RequestBody @Valid AccessLog accessLog) {
         log.debug("REST request to save AccessLog : {}", accessLog);
         return new ResponseEntity<>(entityService.create(accessLog), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /accessLog} : Updates an existing accessLog.
     *
     * @param accessLog the accessLog to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessLog,
     * or with status {@code 400 (Bad Request)} if the accessLog is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessLog couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<AccessLog> updateAccessLog(@Valid @RequestBody AccessLog accessLog) {
        log.debug("REST request to update AccessLog : {}", accessLog);
        AccessLog result = entityService.update(accessLog);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /accessLog} : get all the accessLogs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessLog in body.
     */

    @GetMapping()
    public ResponseEntity<List<AccessLog>> getAllAccessLog() {
	    log.debug("REST request to get all accessLogs");
        List<AccessLog> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /accessLog/:id} : get the "id" accessLog.
     *
     * @param id the id of the accessLog to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessLog, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccessLog> getAccessLog(@PathVariable Integer id) {
        log.debug("REST request to get AccessLog : {}", id);
        AccessLog e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /accessLog/:id} : delete the "id" accessLog.
     *
     * @param id the id of the accessLog to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessLog(@PathVariable Integer id) {
        log.debug("REST request to delete AccessLog : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
