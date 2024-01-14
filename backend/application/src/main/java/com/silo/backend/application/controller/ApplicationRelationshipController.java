
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationRelationship;
import com.silo.backend.service.ApplicationRelationshipService;


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
 * REST controller for managing {@link ApplicationRelationship}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationRelationship")
public class ApplicationRelationshipController {

    private final Logger log = LoggerFactory.getLogger(ApplicationRelationshipController.class);
	
    private final ApplicationRelationshipService entityService;

 	public ApplicationRelationshipController (ApplicationRelationshipService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationRelationship} : Create a new applicationRelationship.
     *
     * @param applicationRelationship the applicationRelationship to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationRelationship.
     */
	@PostMapping()
	public ResponseEntity<ApplicationRelationship> createApplicationRelationship(@RequestBody @Valid ApplicationRelationship applicationRelationship) {
         log.debug("REST request to save ApplicationRelationship : {}", applicationRelationship);
         return new ResponseEntity<>(entityService.create(applicationRelationship), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationRelationship} : Updates an existing applicationRelationship.
     *
     * @param applicationRelationship the applicationRelationship to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationRelationship,
     * or with status {@code 400 (Bad Request)} if the applicationRelationship is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationRelationship couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationRelationship> updateApplicationRelationship(@Valid @RequestBody ApplicationRelationship applicationRelationship) {
        log.debug("REST request to update ApplicationRelationship : {}", applicationRelationship);
        ApplicationRelationship result = entityService.update(applicationRelationship);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationRelationship} : get all the applicationRelationships.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationRelationship in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationRelationship>> getAllApplicationRelationship() {
	    log.debug("REST request to get all applicationRelationships");
        List<ApplicationRelationship> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationRelationship/:id} : get the "id" applicationRelationship.
     *
     * @param id the id of the applicationRelationship to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationRelationship, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationRelationship> getApplicationRelationship(@PathVariable Long id) {
        log.debug("REST request to get ApplicationRelationship : {}", id);
        ApplicationRelationship e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationRelationship/:id} : delete the "id" applicationRelationship.
     *
     * @param id the id of the applicationRelationship to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationRelationship(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationRelationship : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
