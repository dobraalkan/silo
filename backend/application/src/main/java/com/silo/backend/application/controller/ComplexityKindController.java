
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ComplexityKind;
import com.silo.backend.service.ComplexityKindService;


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
 * REST controller for managing {@link ComplexityKind}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/complexityKind")
public class ComplexityKindController {

    private final Logger log = LoggerFactory.getLogger(ComplexityKindController.class);
	
    private final ComplexityKindService entityService;

 	public ComplexityKindController (ComplexityKindService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /complexityKind} : Create a new complexityKind.
     *
     * @param complexityKind the complexityKind to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new complexityKind.
     */
	@PostMapping()
	public ResponseEntity<ComplexityKind> createComplexityKind(@RequestBody @Valid ComplexityKind complexityKind) {
         log.debug("REST request to save ComplexityKind : {}", complexityKind);
         return new ResponseEntity<>(entityService.create(complexityKind), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /complexityKind} : Updates an existing complexityKind.
     *
     * @param complexityKind the complexityKind to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated complexityKind,
     * or with status {@code 400 (Bad Request)} if the complexityKind is not valid,
     * or with status {@code 500 (Internal Server Error)} if the complexityKind couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ComplexityKind> updateComplexityKind(@Valid @RequestBody ComplexityKind complexityKind) {
        log.debug("REST request to update ComplexityKind : {}", complexityKind);
        ComplexityKind result = entityService.update(complexityKind);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /complexityKind} : get all the complexityKinds.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of complexityKind in body.
     */

    @GetMapping()
    public ResponseEntity<List<ComplexityKind>> getAllComplexityKind() {
	    log.debug("REST request to get all complexityKinds");
        List<ComplexityKind> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /complexityKind/:id} : get the "id" complexityKind.
     *
     * @param id the id of the complexityKind to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the complexityKind, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ComplexityKind> getComplexityKind(@PathVariable Long id) {
        log.debug("REST request to get ComplexityKind : {}", id);
        ComplexityKind e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /complexityKind/:id} : delete the "id" complexityKind.
     *
     * @param id the id of the complexityKind to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplexityKind(@PathVariable Long id) {
        log.debug("REST request to delete ComplexityKind : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
