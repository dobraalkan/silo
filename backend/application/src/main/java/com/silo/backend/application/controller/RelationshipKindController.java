
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.RelationshipKind;
import com.silo.backend.service.RelationshipKindService;


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
 * REST controller for managing {@link RelationshipKind}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/relationshipKind")
public class RelationshipKindController {

    private final Logger log = LoggerFactory.getLogger(RelationshipKindController.class);
	
    private final RelationshipKindService entityService;

 	public RelationshipKindController (RelationshipKindService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /relationshipKind} : Create a new relationshipKind.
     *
     * @param relationshipKind the relationshipKind to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new relationshipKind.
     */
	@PostMapping()
	public ResponseEntity<RelationshipKind> createRelationshipKind(@RequestBody @Valid RelationshipKind relationshipKind) {
         log.debug("REST request to save RelationshipKind : {}", relationshipKind);
         return new ResponseEntity<>(entityService.create(relationshipKind), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /relationshipKind} : Updates an existing relationshipKind.
     *
     * @param relationshipKind the relationshipKind to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated relationshipKind,
     * or with status {@code 400 (Bad Request)} if the relationshipKind is not valid,
     * or with status {@code 500 (Internal Server Error)} if the relationshipKind couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<RelationshipKind> updateRelationshipKind(@Valid @RequestBody RelationshipKind relationshipKind) {
        log.debug("REST request to update RelationshipKind : {}", relationshipKind);
        RelationshipKind result = entityService.update(relationshipKind);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /relationshipKind} : get all the relationshipKinds.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of relationshipKind in body.
     */

    @GetMapping()
    public ResponseEntity<List<RelationshipKind>> getAllRelationshipKind() {
	    log.debug("REST request to get all relationshipKinds");
        List<RelationshipKind> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /relationshipKind/:id} : get the "id" relationshipKind.
     *
     * @param id the id of the relationshipKind to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the relationshipKind, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<RelationshipKind> getRelationshipKind(@PathVariable Long id) {
        log.debug("REST request to get RelationshipKind : {}", id);
        RelationshipKind e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /relationshipKind/:id} : delete the "id" relationshipKind.
     *
     * @param id the id of the relationshipKind to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelationshipKind(@PathVariable Long id) {
        log.debug("REST request to delete RelationshipKind : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
