
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.DatabaseUsage;
import com.silo.backend.service.DatabaseUsageService;


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
 * REST controller for managing {@link DatabaseUsage}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/databaseUsage")
public class DatabaseUsageController {

    private final Logger log = LoggerFactory.getLogger(DatabaseUsageController.class);
	
    private final DatabaseUsageService entityService;

 	public DatabaseUsageController (DatabaseUsageService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /databaseUsage} : Create a new databaseUsage.
     *
     * @param databaseUsage the databaseUsage to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new databaseUsage.
     */
	@PostMapping()
	public ResponseEntity<DatabaseUsage> createDatabaseUsage(@RequestBody @Valid DatabaseUsage databaseUsage) {
         log.debug("REST request to save DatabaseUsage : {}", databaseUsage);
         return new ResponseEntity<>(entityService.create(databaseUsage), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /databaseUsage} : Updates an existing databaseUsage.
     *
     * @param databaseUsage the databaseUsage to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated databaseUsage,
     * or with status {@code 400 (Bad Request)} if the databaseUsage is not valid,
     * or with status {@code 500 (Internal Server Error)} if the databaseUsage couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<DatabaseUsage> updateDatabaseUsage(@Valid @RequestBody DatabaseUsage databaseUsage) {
        log.debug("REST request to update DatabaseUsage : {}", databaseUsage);
        DatabaseUsage result = entityService.update(databaseUsage);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /databaseUsage} : get all the databaseUsages.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of databaseUsage in body.
     */

    @GetMapping()
    public ResponseEntity<List<DatabaseUsage>> getAllDatabaseUsage() {
	    log.debug("REST request to get all databaseUsages");
        List<DatabaseUsage> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /databaseUsage/:id} : get the "id" databaseUsage.
     *
     * @param id the id of the databaseUsage to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the databaseUsage, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<DatabaseUsage> getDatabaseUsage(@PathVariable Long id) {
        log.debug("REST request to get DatabaseUsage : {}", id);
        DatabaseUsage e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /databaseUsage/:id} : delete the "id" databaseUsage.
     *
     * @param id the id of the databaseUsage to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatabaseUsage(@PathVariable Long id) {
        log.debug("REST request to delete DatabaseUsage : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
