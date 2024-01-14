
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.CustomEnvironmentUsage;
import com.silo.backend.service.CustomEnvironmentUsageService;


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
 * REST controller for managing {@link CustomEnvironmentUsage}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/customEnvironmentUsage")
public class CustomEnvironmentUsageController {

    private final Logger log = LoggerFactory.getLogger(CustomEnvironmentUsageController.class);
	
    private final CustomEnvironmentUsageService entityService;

 	public CustomEnvironmentUsageController (CustomEnvironmentUsageService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /customEnvironmentUsage} : Create a new customEnvironmentUsage.
     *
     * @param customEnvironmentUsage the customEnvironmentUsage to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new customEnvironmentUsage.
     */
	@PostMapping()
	public ResponseEntity<CustomEnvironmentUsage> createCustomEnvironmentUsage(@RequestBody @Valid CustomEnvironmentUsage customEnvironmentUsage) {
         log.debug("REST request to save CustomEnvironmentUsage : {}", customEnvironmentUsage);
         return new ResponseEntity<>(entityService.create(customEnvironmentUsage), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /customEnvironmentUsage} : Updates an existing customEnvironmentUsage.
     *
     * @param customEnvironmentUsage the customEnvironmentUsage to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated customEnvironmentUsage,
     * or with status {@code 400 (Bad Request)} if the customEnvironmentUsage is not valid,
     * or with status {@code 500 (Internal Server Error)} if the customEnvironmentUsage couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<CustomEnvironmentUsage> updateCustomEnvironmentUsage(@Valid @RequestBody CustomEnvironmentUsage customEnvironmentUsage) {
        log.debug("REST request to update CustomEnvironmentUsage : {}", customEnvironmentUsage);
        CustomEnvironmentUsage result = entityService.update(customEnvironmentUsage);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /customEnvironmentUsage} : get all the customEnvironmentUsages.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customEnvironmentUsage in body.
     */

    @GetMapping()
    public ResponseEntity<List<CustomEnvironmentUsage>> getAllCustomEnvironmentUsage() {
	    log.debug("REST request to get all customEnvironmentUsages");
        List<CustomEnvironmentUsage> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /customEnvironmentUsage/:id} : get the "id" customEnvironmentUsage.
     *
     * @param id the id of the customEnvironmentUsage to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customEnvironmentUsage, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomEnvironmentUsage> getCustomEnvironmentUsage(@PathVariable Long id) {
        log.debug("REST request to get CustomEnvironmentUsage : {}", id);
        CustomEnvironmentUsage e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /customEnvironmentUsage/:id} : delete the "id" customEnvironmentUsage.
     *
     * @param id the id of the customEnvironmentUsage to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomEnvironmentUsage(@PathVariable Long id) {
        log.debug("REST request to delete CustomEnvironmentUsage : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
