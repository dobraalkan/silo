
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.UserPreference;
import com.silo.backend.service.UserPreferenceService;


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
 * REST controller for managing {@link UserPreference}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/userPreference")
public class UserPreferenceController {

    private final Logger log = LoggerFactory.getLogger(UserPreferenceController.class);
	
    private final UserPreferenceService entityService;

 	public UserPreferenceController (UserPreferenceService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /userPreference} : Create a new userPreference.
     *
     * @param userPreference the userPreference to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userPreference.
     */
	@PostMapping()
	public ResponseEntity<UserPreference> createUserPreference(@RequestBody @Valid UserPreference userPreference) {
         log.debug("REST request to save UserPreference : {}", userPreference);
         return new ResponseEntity<>(entityService.create(userPreference), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /userPreference} : Updates an existing userPreference.
     *
     * @param userPreference the userPreference to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userPreference,
     * or with status {@code 400 (Bad Request)} if the userPreference is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userPreference couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<UserPreference> updateUserPreference(@Valid @RequestBody UserPreference userPreference) {
        log.debug("REST request to update UserPreference : {}", userPreference);
        UserPreference result = entityService.update(userPreference);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /userPreference} : get all the userPreferences.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userPreference in body.
     */

    @GetMapping()
    public ResponseEntity<List<UserPreference>> getAllUserPreference() {
	    log.debug("REST request to get all userPreferences");
        List<UserPreference> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /userPreference/:id} : get the "id" userPreference.
     *
     * @param id the id of the userPreference to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userPreference, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserPreference> getUserPreference(@PathVariable String id) {
        log.debug("REST request to get UserPreference : {}", id);
        UserPreference e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /userPreference/:id} : delete the "id" userPreference.
     *
     * @param id the id of the userPreference to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserPreference(@PathVariable String id) {
        log.debug("REST request to delete UserPreference : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
