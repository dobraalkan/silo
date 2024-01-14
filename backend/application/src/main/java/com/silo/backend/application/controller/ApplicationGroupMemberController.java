
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationGroupMember;
import com.silo.backend.service.ApplicationGroupMemberService;


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
 * REST controller for managing {@link ApplicationGroupMember}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationGroupMember")
public class ApplicationGroupMemberController {

    private final Logger log = LoggerFactory.getLogger(ApplicationGroupMemberController.class);
	
    private final ApplicationGroupMemberService entityService;

 	public ApplicationGroupMemberController (ApplicationGroupMemberService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationGroupMember} : Create a new applicationGroupMember.
     *
     * @param applicationGroupMember the applicationGroupMember to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationGroupMember.
     */
	@PostMapping()
	public ResponseEntity<ApplicationGroupMember> createApplicationGroupMember(@RequestBody @Valid ApplicationGroupMember applicationGroupMember) {
         log.debug("REST request to save ApplicationGroupMember : {}", applicationGroupMember);
         return new ResponseEntity<>(entityService.create(applicationGroupMember), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationGroupMember} : Updates an existing applicationGroupMember.
     *
     * @param applicationGroupMember the applicationGroupMember to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationGroupMember,
     * or with status {@code 400 (Bad Request)} if the applicationGroupMember is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationGroupMember couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationGroupMember> updateApplicationGroupMember(@Valid @RequestBody ApplicationGroupMember applicationGroupMember) {
        log.debug("REST request to update ApplicationGroupMember : {}", applicationGroupMember);
        ApplicationGroupMember result = entityService.update(applicationGroupMember);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationGroupMember} : get all the applicationGroupMembers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationGroupMember in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationGroupMember>> getAllApplicationGroupMember() {
	    log.debug("REST request to get all applicationGroupMembers");
        List<ApplicationGroupMember> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationGroupMember/:id} : get the "id" applicationGroupMember.
     *
     * @param id the id of the applicationGroupMember to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationGroupMember, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationGroupMember> getApplicationGroupMember(@PathVariable Long id) {
        log.debug("REST request to get ApplicationGroupMember : {}", id);
        ApplicationGroupMember e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationGroupMember/:id} : delete the "id" applicationGroupMember.
     *
     * @param id the id of the applicationGroupMember to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationGroupMember(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationGroupMember : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
