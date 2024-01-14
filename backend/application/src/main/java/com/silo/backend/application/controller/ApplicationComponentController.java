
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.ApplicationComponent;
import com.silo.backend.service.ApplicationComponentService;


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
 * REST controller for managing {@link ApplicationComponent}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/applicationComponent")
public class ApplicationComponentController {

    private final Logger log = LoggerFactory.getLogger(ApplicationComponentController.class);
	
    private final ApplicationComponentService entityService;

 	public ApplicationComponentController (ApplicationComponentService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /applicationComponent} : Create a new applicationComponent.
     *
     * @param applicationComponent the applicationComponent to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new applicationComponent.
     */
	@PostMapping()
	public ResponseEntity<ApplicationComponent> createApplicationComponent(@RequestBody @Valid ApplicationComponent applicationComponent) {
         log.debug("REST request to save ApplicationComponent : {}", applicationComponent);
         return new ResponseEntity<>(entityService.create(applicationComponent), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /applicationComponent} : Updates an existing applicationComponent.
     *
     * @param applicationComponent the applicationComponent to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated applicationComponent,
     * or with status {@code 400 (Bad Request)} if the applicationComponent is not valid,
     * or with status {@code 500 (Internal Server Error)} if the applicationComponent couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<ApplicationComponent> updateApplicationComponent(@Valid @RequestBody ApplicationComponent applicationComponent) {
        log.debug("REST request to update ApplicationComponent : {}", applicationComponent);
        ApplicationComponent result = entityService.update(applicationComponent);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /applicationComponent} : get all the applicationComponents.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of applicationComponent in body.
     */

    @GetMapping()
    public ResponseEntity<List<ApplicationComponent>> getAllApplicationComponent() {
	    log.debug("REST request to get all applicationComponents");
        List<ApplicationComponent> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /applicationComponent/:id} : get the "id" applicationComponent.
     *
     * @param id the id of the applicationComponent to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the applicationComponent, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApplicationComponent> getApplicationComponent(@PathVariable Long id) {
        log.debug("REST request to get ApplicationComponent : {}", id);
        ApplicationComponent e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /applicationComponent/:id} : delete the "id" applicationComponent.
     *
     * @param id the id of the applicationComponent to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationComponent(@PathVariable Long id) {
        log.debug("REST request to delete ApplicationComponent : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
