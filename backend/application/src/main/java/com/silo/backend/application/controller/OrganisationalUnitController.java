
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.OrganisationalUnit;
import com.silo.backend.service.OrganisationalUnitService;


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
 * REST controller for managing {@link OrganisationalUnit}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/organisationalUnit")
public class OrganisationalUnitController {

    private final Logger log = LoggerFactory.getLogger(OrganisationalUnitController.class);
	
    private final OrganisationalUnitService entityService;

 	public OrganisationalUnitController (OrganisationalUnitService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /organisationalUnit} : Create a new organisationalUnit.
     *
     * @param organisationalUnit the organisationalUnit to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new organisationalUnit.
     */
	@PostMapping()
	public ResponseEntity<OrganisationalUnit> createOrganisationalUnit(@RequestBody @Valid OrganisationalUnit organisationalUnit) {
         log.debug("REST request to save OrganisationalUnit : {}", organisationalUnit);
         return new ResponseEntity<>(entityService.create(organisationalUnit), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /organisationalUnit} : Updates an existing organisationalUnit.
     *
     * @param organisationalUnit the organisationalUnit to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated organisationalUnit,
     * or with status {@code 400 (Bad Request)} if the organisationalUnit is not valid,
     * or with status {@code 500 (Internal Server Error)} if the organisationalUnit couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<OrganisationalUnit> updateOrganisationalUnit(@Valid @RequestBody OrganisationalUnit organisationalUnit) {
        log.debug("REST request to update OrganisationalUnit : {}", organisationalUnit);
        OrganisationalUnit result = entityService.update(organisationalUnit);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /organisationalUnit} : get all the organisationalUnits.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of organisationalUnit in body.
     */

    @GetMapping()
    public ResponseEntity<List<OrganisationalUnit>> getAllOrganisationalUnit() {
	    log.debug("REST request to get all organisationalUnits");
        List<OrganisationalUnit> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /organisationalUnit/:id} : get the "id" organisationalUnit.
     *
     * @param id the id of the organisationalUnit to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the organisationalUnit, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrganisationalUnit> getOrganisationalUnit(@PathVariable Long id) {
        log.debug("REST request to get OrganisationalUnit : {}", id);
        OrganisationalUnit e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /organisationalUnit/:id} : delete the "id" organisationalUnit.
     *
     * @param id the id of the organisationalUnit to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisationalUnit(@PathVariable Long id) {
        log.debug("REST request to delete OrganisationalUnit : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
