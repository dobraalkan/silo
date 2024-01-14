
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ServerUsage;
import com.silo.backend.service.ServerUsageService;


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
 * REST controller for managing {@link ServerUsage}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/serverUsage")
public class ServerUsageController {

    private final Logger log = LoggerFactory.getLogger(ServerUsageController.class);
	
    private final ServerUsageService entityService;

 	public ServerUsageController (ServerUsageService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /serverUsage} : Create a new serverUsage.
     *
     * @param serverUsage the serverUsage to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new serverUsage.
     */
	@PostMapping()
	public ResponseEntity<ServerUsage> createServerUsage(@RequestBody @Valid ServerUsage serverUsage) {
         log.debug("REST request to save ServerUsage : {}", serverUsage);
         return new ResponseEntity<>(entityService.create(serverUsage), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /serverUsage} : Updates an existing serverUsage.
     *
     * @param serverUsage the serverUsage to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated serverUsage,
     * or with status {@code 400 (Bad Request)} if the serverUsage is not valid,
     * or with status {@code 500 (Internal Server Error)} if the serverUsage couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ServerUsage> updateServerUsage(@Valid @RequestBody ServerUsage serverUsage) {
        log.debug("REST request to update ServerUsage : {}", serverUsage);
        ServerUsage result = entityService.update(serverUsage);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /serverUsage} : get all the serverUsages.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of serverUsage in body.
     */

    @GetMapping()
    public ResponseEntity<List<ServerUsage>> getAllServerUsage() {
	    log.debug("REST request to get all serverUsages");
        List<ServerUsage> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /serverUsage/:id} : get the "id" serverUsage.
     *
     * @param id the id of the serverUsage to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the serverUsage, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServerUsage> getServerUsage(@PathVariable Long id) {
        log.debug("REST request to get ServerUsage : {}", id);
        ServerUsage e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /serverUsage/:id} : delete the "id" serverUsage.
     *
     * @param id the id of the serverUsage to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServerUsage(@PathVariable Long id) {
        log.debug("REST request to delete ServerUsage : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
