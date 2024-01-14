
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Actor;
import com.silo.backend.service.ActorService;


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
 * REST controller for managing {@link Actor}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/actor")
public class ActorController {

    private final Logger log = LoggerFactory.getLogger(ActorController.class);
	
    private final ActorService entityService;

 	public ActorController (ActorService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /actor} : Create a new actor.
     *
     * @param actor the actor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new actor.
     */
	@PostMapping()
	public ResponseEntity<Actor> createActor(@RequestBody @Valid Actor actor) {
         log.debug("REST request to save Actor : {}", actor);
         return new ResponseEntity<>(entityService.create(actor), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /actor} : Updates an existing actor.
     *
     * @param actor the actor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated actor,
     * or with status {@code 400 (Bad Request)} if the actor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the actor couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Actor> updateActor(@Valid @RequestBody Actor actor) {
        log.debug("REST request to update Actor : {}", actor);
        Actor result = entityService.update(actor);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /actor} : get all the actors.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of actor in body.
     */

    @GetMapping()
    public ResponseEntity<List<Actor>> getAllActor() {
	    log.debug("REST request to get all actors");
        List<Actor> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /actor/:id} : get the "id" actor.
     *
     * @param id the id of the actor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the actor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        log.debug("REST request to get Actor : {}", id);
        Actor e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /actor/:id} : delete the "id" actor.
     *
     * @param id the id of the actor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        log.debug("REST request to delete Actor : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
