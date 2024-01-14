
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationGroupOuEntry;
import com.silo.backend.service.ApplicationGroupOuEntryService;


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
 * REST controller for managing {@link ApplicationGroupOuEntry}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationGroupOuEntry")
public class ApplicationGroupOuEntryController {

    private final Logger log = LoggerFactory.getLogger(ApplicationGroupOuEntryController.class);
	
    private final ApplicationGroupOuEntryService entityService;

 	public ApplicationGroupOuEntryController (ApplicationGroupOuEntryService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationGroupOuEntry} : Create a new applicationGroupOuEntry.
     *
     * @param applicationGroupOuEntry the applicationGroupOuEntry to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationGroupOuEntry.
     */
	@PostMapping()
	public ResponseEntity<ApplicationGroupOuEntry> createApplicationGroupOuEntry(@RequestBody @Valid ApplicationGroupOuEntry applicationGroupOuEntry) {
         log.debug("REST request to save ApplicationGroupOuEntry : {}", applicationGroupOuEntry);
         return new ResponseEntity<>(entityService.create(applicationGroupOuEntry), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationGroupOuEntry} : Updates an existing applicationGroupOuEntry.
     *
     * @param applicationGroupOuEntry the applicationGroupOuEntry to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationGroupOuEntry,
     * or with status {@code 400 (Bad Request)} if the applicationGroupOuEntry is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationGroupOuEntry couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationGroupOuEntry> updateApplicationGroupOuEntry(@Valid @RequestBody ApplicationGroupOuEntry applicationGroupOuEntry) {
        log.debug("REST request to update ApplicationGroupOuEntry : {}", applicationGroupOuEntry);
        ApplicationGroupOuEntry result = entityService.update(applicationGroupOuEntry);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationGroupOuEntry} : get all the applicationGroupOuEntrys.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationGroupOuEntry in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationGroupOuEntry>> getAllApplicationGroupOuEntry() {
	    log.debug("REST request to get all applicationGroupOuEntrys");
        List<ApplicationGroupOuEntry> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationGroupOuEntry/:id} : get the "id" applicationGroupOuEntry.
     *
     * @param id the id of the applicationGroupOuEntry to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationGroupOuEntry, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationGroupOuEntry> getApplicationGroupOuEntry(@PathVariable Long id) {
        log.debug("REST request to get ApplicationGroupOuEntry : {}", id);
        ApplicationGroupOuEntry e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationGroupOuEntry/:id} : delete the "id" applicationGroupOuEntry.
     *
     * @param id the id of the applicationGroupOuEntry to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationGroupOuEntry(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationGroupOuEntry : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
