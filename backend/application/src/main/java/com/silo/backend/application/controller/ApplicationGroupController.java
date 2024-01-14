
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationGroup;
import com.silo.backend.service.ApplicationGroupService;


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
 * REST controller for managing {@link ApplicationGroup}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationGroup")
public class ApplicationGroupController {

    private final Logger log = LoggerFactory.getLogger(ApplicationGroupController.class);
	
    private final ApplicationGroupService entityService;

 	public ApplicationGroupController (ApplicationGroupService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationGroup} : Create a new applicationGroup.
     *
     * @param applicationGroup the applicationGroup to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationGroup.
     */
	@PostMapping()
	public ResponseEntity<ApplicationGroup> createApplicationGroup(@RequestBody @Valid ApplicationGroup applicationGroup) {
         log.debug("REST request to save ApplicationGroup : {}", applicationGroup);
         return new ResponseEntity<>(entityService.create(applicationGroup), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationGroup} : Updates an existing applicationGroup.
     *
     * @param applicationGroup the applicationGroup to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationGroup,
     * or with status {@code 400 (Bad Request)} if the applicationGroup is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationGroup couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationGroup> updateApplicationGroup(@Valid @RequestBody ApplicationGroup applicationGroup) {
        log.debug("REST request to update ApplicationGroup : {}", applicationGroup);
        ApplicationGroup result = entityService.update(applicationGroup);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationGroup} : get all the applicationGroups.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationGroup in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationGroup>> getAllApplicationGroup() {
	    log.debug("REST request to get all applicationGroups");
        List<ApplicationGroup> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationGroup/:id} : get the "id" applicationGroup.
     *
     * @param id the id of the applicationGroup to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationGroup, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationGroup> getApplicationGroup(@PathVariable Long id) {
        log.debug("REST request to get ApplicationGroup : {}", id);
        ApplicationGroup e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationGroup/:id} : delete the "id" applicationGroup.
     *
     * @param id the id of the applicationGroup to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationGroup(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationGroup : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
