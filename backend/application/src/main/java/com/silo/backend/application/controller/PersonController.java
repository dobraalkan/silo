
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Person;
import com.silo.backend.service.PersonService;


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
 * REST controller for managing {@link Person}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final Logger log = LoggerFactory.getLogger(PersonController.class);
	
    private final PersonService entityService;

 	public PersonController (PersonService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /person} : Create a new person.
     *
     * @param person the person to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new person.
     */
	@PostMapping()
	public ResponseEntity<Person> createPerson(@RequestBody @Valid Person person) {
         log.debug("REST request to save Person : {}", person);
         return new ResponseEntity<>(entityService.create(person), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /person} : Updates an existing person.
     *
     * @param person the person to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated person,
     * or with status {@code 400 (Bad Request)} if the person is not valid,
     * or with status {@code 500 (Internal Server Error)} if the person couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person) {
        log.debug("REST request to update Person : {}", person);
        Person result = entityService.update(person);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /person} : get all the persons.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of person in body.
     */

    @GetMapping()
    public ResponseEntity<List<Person>> getAllPerson() {
	    log.debug("REST request to get all persons");
        List<Person> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /person/:id} : get the "id" person.
     *
     * @param id the id of the person to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the person, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        log.debug("REST request to get Person : {}", id);
        Person e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /person/:id} : delete the "id" person.
     *
     * @param id the id of the person to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        log.debug("REST request to delete Person : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
