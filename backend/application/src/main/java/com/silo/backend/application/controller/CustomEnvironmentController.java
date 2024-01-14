
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.CustomEnvironment;
import com.silo.backend.service.CustomEnvironmentService;


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
 * REST controller for managing {@link CustomEnvironment}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/customEnvironment")
public class CustomEnvironmentController {

    private final Logger log = LoggerFactory.getLogger(CustomEnvironmentController.class);
	
    private final CustomEnvironmentService entityService;

 	public CustomEnvironmentController (CustomEnvironmentService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /customEnvironment} : Create a new customEnvironment.
     *
     * @param customEnvironment the customEnvironment to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new customEnvironment.
     */
	@PostMapping()
	public ResponseEntity<CustomEnvironment> createCustomEnvironment(@RequestBody @Valid CustomEnvironment customEnvironment) {
         log.debug("REST request to save CustomEnvironment : {}", customEnvironment);
         return new ResponseEntity<>(entityService.create(customEnvironment), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /customEnvironment} : Updates an existing customEnvironment.
     *
     * @param customEnvironment the customEnvironment to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated customEnvironment,
     * or with status {@code 400 (Bad Request)} if the customEnvironment is not valid,
     * or with status {@code 500 (Internal Server Error)} if the customEnvironment couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<CustomEnvironment> updateCustomEnvironment(@Valid @RequestBody CustomEnvironment customEnvironment) {
        log.debug("REST request to update CustomEnvironment : {}", customEnvironment);
        CustomEnvironment result = entityService.update(customEnvironment);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /customEnvironment} : get all the customEnvironments.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customEnvironment in body.
     */

    @GetMapping()
    public ResponseEntity<List<CustomEnvironment>> getAllCustomEnvironment() {
	    log.debug("REST request to get all customEnvironments");
        List<CustomEnvironment> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /customEnvironment/:id} : get the "id" customEnvironment.
     *
     * @param id the id of the customEnvironment to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customEnvironment, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomEnvironment> getCustomEnvironment(@PathVariable Long id) {
        log.debug("REST request to get CustomEnvironment : {}", id);
        CustomEnvironment e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /customEnvironment/:id} : delete the "id" customEnvironment.
     *
     * @param id the id of the customEnvironment to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomEnvironment(@PathVariable Long id) {
        log.debug("REST request to delete CustomEnvironment : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
