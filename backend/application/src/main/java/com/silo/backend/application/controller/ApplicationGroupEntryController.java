
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationGroupEntry;
import com.silo.backend.service.ApplicationGroupEntryService;


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
 * REST controller for managing {@link ApplicationGroupEntry}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationGroupEntry")
public class ApplicationGroupEntryController {

    private final Logger log = LoggerFactory.getLogger(ApplicationGroupEntryController.class);
	
    private final ApplicationGroupEntryService entityService;

 	public ApplicationGroupEntryController (ApplicationGroupEntryService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationGroupEntry} : Create a new applicationGroupEntry.
     *
     * @param applicationGroupEntry the applicationGroupEntry to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationGroupEntry.
     */
	@PostMapping()
	public ResponseEntity<ApplicationGroupEntry> createApplicationGroupEntry(@RequestBody @Valid ApplicationGroupEntry applicationGroupEntry) {
         log.debug("REST request to save ApplicationGroupEntry : {}", applicationGroupEntry);
         return new ResponseEntity<>(entityService.create(applicationGroupEntry), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationGroupEntry} : Updates an existing applicationGroupEntry.
     *
     * @param applicationGroupEntry the applicationGroupEntry to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationGroupEntry,
     * or with status {@code 400 (Bad Request)} if the applicationGroupEntry is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationGroupEntry couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationGroupEntry> updateApplicationGroupEntry(@Valid @RequestBody ApplicationGroupEntry applicationGroupEntry) {
        log.debug("REST request to update ApplicationGroupEntry : {}", applicationGroupEntry);
        ApplicationGroupEntry result = entityService.update(applicationGroupEntry);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationGroupEntry} : get all the applicationGroupEntrys.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationGroupEntry in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationGroupEntry>> getAllApplicationGroupEntry() {
	    log.debug("REST request to get all applicationGroupEntrys");
        List<ApplicationGroupEntry> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationGroupEntry/:id} : get the "id" applicationGroupEntry.
     *
     * @param id the id of the applicationGroupEntry to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationGroupEntry, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationGroupEntry> getApplicationGroupEntry(@PathVariable Long id) {
        log.debug("REST request to get ApplicationGroupEntry : {}", id);
        ApplicationGroupEntry e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationGroupEntry/:id} : delete the "id" applicationGroupEntry.
     *
     * @param id the id of the applicationGroupEntry to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationGroupEntry(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationGroupEntry : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
