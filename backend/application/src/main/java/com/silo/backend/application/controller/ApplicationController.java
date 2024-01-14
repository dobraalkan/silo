
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Application;
import com.silo.backend.service.ApplicationService;


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
 * REST controller for managing {@link Application}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private final Logger log = LoggerFactory.getLogger(ApplicationController.class);
	
    private final ApplicationService entityService;

 	public ApplicationController (ApplicationService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /application} : Create a new application.
     *
     * @param application the application to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new application.
     */
	@PostMapping()
	public ResponseEntity<Application> createApplication(@RequestBody @Valid Application application) {
         log.debug("REST request to save Application : {}", application);
         return new ResponseEntity<>(entityService.create(application), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /application} : Updates an existing application.
     *
     * @param application the application to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated application,
     * or with status {@code 400 (Bad Request)} if the application is not valid,
     * or with status {@code 500 (Internal Server Error)} if the application couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Application> updateApplication(@Valid @RequestBody Application application) {
        log.debug("REST request to update Application : {}", application);
        Application result = entityService.update(application);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /application} : get all the applications.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of application in body.
     */

    @GetMapping()
    public ResponseEntity<List<Application>> getAllApplication() {
	    log.debug("REST request to get all applications");
        List<Application> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /application/:id} : get the "id" application.
     *
     * @param id the id of the application to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the application, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable Long id) {
        log.debug("REST request to get Application : {}", id);
        Application e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /application/:id} : delete the "id" application.
     *
     * @param id the id of the application to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        log.debug("REST request to delete Application : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
