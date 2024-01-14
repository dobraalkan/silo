
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Complexity;
import com.silo.backend.service.ComplexityService;


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
 * REST controller for managing {@link Complexity}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/complexity")
public class ComplexityController {

    private final Logger log = LoggerFactory.getLogger(ComplexityController.class);
	
    private final ComplexityService entityService;

 	public ComplexityController (ComplexityService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /complexity} : Create a new complexity.
     *
     * @param complexity the complexity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new complexity.
     */
	@PostMapping()
	public ResponseEntity<Complexity> createComplexity(@RequestBody @Valid Complexity complexity) {
         log.debug("REST request to save Complexity : {}", complexity);
         return new ResponseEntity<>(entityService.create(complexity), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /complexity} : Updates an existing complexity.
     *
     * @param complexity the complexity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated complexity,
     * or with status {@code 400 (Bad Request)} if the complexity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the complexity couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Complexity> updateComplexity(@Valid @RequestBody Complexity complexity) {
        log.debug("REST request to update Complexity : {}", complexity);
        Complexity result = entityService.update(complexity);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /complexity} : get all the complexitys.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of complexity in body.
     */

    @GetMapping()
    public ResponseEntity<List<Complexity>> getAllComplexity() {
	    log.debug("REST request to get all complexitys");
        List<Complexity> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /complexity/:id} : get the "id" complexity.
     *
     * @param id the id of the complexity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the complexity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Complexity> getComplexity(@PathVariable Long id) {
        log.debug("REST request to get Complexity : {}", id);
        Complexity e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /complexity/:id} : delete the "id" complexity.
     *
     * @param id the id of the complexity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplexity(@PathVariable Long id) {
        log.debug("REST request to delete Complexity : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
