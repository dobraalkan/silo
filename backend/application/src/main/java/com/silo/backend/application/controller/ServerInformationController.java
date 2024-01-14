
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ServerInformation;
import com.silo.backend.service.ServerInformationService;


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
 * REST controller for managing {@link ServerInformation}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/serverInformation")
public class ServerInformationController {

    private final Logger log = LoggerFactory.getLogger(ServerInformationController.class);
	
    private final ServerInformationService entityService;

 	public ServerInformationController (ServerInformationService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /serverInformation} : Create a new serverInformation.
     *
     * @param serverInformation the serverInformation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new serverInformation.
     */
	@PostMapping()
	public ResponseEntity<ServerInformation> createServerInformation(@RequestBody @Valid ServerInformation serverInformation) {
         log.debug("REST request to save ServerInformation : {}", serverInformation);
         return new ResponseEntity<>(entityService.create(serverInformation), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /serverInformation} : Updates an existing serverInformation.
     *
     * @param serverInformation the serverInformation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated serverInformation,
     * or with status {@code 400 (Bad Request)} if the serverInformation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the serverInformation couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ServerInformation> updateServerInformation(@Valid @RequestBody ServerInformation serverInformation) {
        log.debug("REST request to update ServerInformation : {}", serverInformation);
        ServerInformation result = entityService.update(serverInformation);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /serverInformation} : get all the serverInformations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of serverInformation in body.
     */

    @GetMapping()
    public ResponseEntity<List<ServerInformation>> getAllServerInformation() {
	    log.debug("REST request to get all serverInformations");
        List<ServerInformation> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /serverInformation/:id} : get the "id" serverInformation.
     *
     * @param id the id of the serverInformation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the serverInformation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServerInformation> getServerInformation(@PathVariable Long id) {
        log.debug("REST request to get ServerInformation : {}", id);
        ServerInformation e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /serverInformation/:id} : delete the "id" serverInformation.
     *
     * @param id the id of the serverInformation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServerInformation(@PathVariable Long id) {
        log.debug("REST request to delete ServerInformation : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
