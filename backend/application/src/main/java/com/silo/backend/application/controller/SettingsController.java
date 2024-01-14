
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Settings;
import com.silo.backend.service.SettingsService;


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
 * REST controller for managing {@link Settings}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final Logger log = LoggerFactory.getLogger(SettingsController.class);
	
    private final SettingsService entityService;

 	public SettingsController (SettingsService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /settings} : Create a new settings.
     *
     * @param settings the settings to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new settings.
     */
	@PostMapping()
	public ResponseEntity<Settings> createSettings(@RequestBody @Valid Settings settings) {
         log.debug("REST request to save Settings : {}", settings);
         return new ResponseEntity<>(entityService.create(settings), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /settings} : Updates an existing settings.
     *
     * @param settings the settings to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated settings,
     * or with status {@code 400 (Bad Request)} if the settings is not valid,
     * or with status {@code 500 (Internal Server Error)} if the settings couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Settings> updateSettings(@Valid @RequestBody Settings settings) {
        log.debug("REST request to update Settings : {}", settings);
        Settings result = entityService.update(settings);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /settings} : get all the settingss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of settings in body.
     */

    @GetMapping()
    public ResponseEntity<List<Settings>> getAllSettings() {
	    log.debug("REST request to get all settingss");
        List<Settings> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /settings/:id} : get the "id" settings.
     *
     * @param id the id of the settings to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the settings, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Settings> getSettings(@PathVariable String id) {
        log.debug("REST request to get Settings : {}", id);
        Settings e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /settings/:id} : delete the "id" settings.
     *
     * @param id the id of the settings to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSettings(@PathVariable String id) {
        log.debug("REST request to delete Settings : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
