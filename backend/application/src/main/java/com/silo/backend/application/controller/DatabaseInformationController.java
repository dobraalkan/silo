
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.DatabaseInformation;
import com.silo.backend.service.DatabaseInformationService;


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
 * REST controller for managing {@link DatabaseInformation}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/databaseInformation")
public class DatabaseInformationController {

    private final Logger log = LoggerFactory.getLogger(DatabaseInformationController.class);
	
    private final DatabaseInformationService entityService;

 	public DatabaseInformationController (DatabaseInformationService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /databaseInformation} : Create a new databaseInformation.
     *
     * @param databaseInformation the databaseInformation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new databaseInformation.
     */
	@PostMapping()
	public ResponseEntity<DatabaseInformation> createDatabaseInformation(@RequestBody @Valid DatabaseInformation databaseInformation) {
         log.debug("REST request to save DatabaseInformation : {}", databaseInformation);
         return new ResponseEntity<>(entityService.create(databaseInformation), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /databaseInformation} : Updates an existing databaseInformation.
     *
     * @param databaseInformation the databaseInformation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated databaseInformation,
     * or with status {@code 400 (Bad Request)} if the databaseInformation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the databaseInformation couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<DatabaseInformation> updateDatabaseInformation(@Valid @RequestBody DatabaseInformation databaseInformation) {
        log.debug("REST request to update DatabaseInformation : {}", databaseInformation);
        DatabaseInformation result = entityService.update(databaseInformation);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /databaseInformation} : get all the databaseInformations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of databaseInformation in body.
     */

    @GetMapping()
    public ResponseEntity<List<DatabaseInformation>> getAllDatabaseInformation() {
	    log.debug("REST request to get all databaseInformations");
        List<DatabaseInformation> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /databaseInformation/:id} : get the "id" databaseInformation.
     *
     * @param id the id of the databaseInformation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the databaseInformation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<DatabaseInformation> getDatabaseInformation(@PathVariable Long id) {
        log.debug("REST request to get DatabaseInformation : {}", id);
        DatabaseInformation e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /databaseInformation/:id} : delete the "id" databaseInformation.
     *
     * @param id the id of the databaseInformation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatabaseInformation(@PathVariable Long id) {
        log.debug("REST request to delete DatabaseInformation : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
