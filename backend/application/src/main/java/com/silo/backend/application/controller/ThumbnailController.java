
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Thumbnail;
import com.silo.backend.service.ThumbnailService;


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
 * REST controller for managing {@link Thumbnail}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/thumbnail")
public class ThumbnailController {

    private final Logger log = LoggerFactory.getLogger(ThumbnailController.class);
	
    private final ThumbnailService entityService;

 	public ThumbnailController (ThumbnailService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /thumbnail} : Create a new thumbnail.
     *
     * @param thumbnail the thumbnail to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new thumbnail.
     */
	@PostMapping()
	public ResponseEntity<Thumbnail> createThumbnail(@RequestBody @Valid Thumbnail thumbnail) {
         log.debug("REST request to save Thumbnail : {}", thumbnail);
         return new ResponseEntity<>(entityService.create(thumbnail), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /thumbnail} : Updates an existing thumbnail.
     *
     * @param thumbnail the thumbnail to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated thumbnail,
     * or with status {@code 400 (Bad Request)} if the thumbnail is not valid,
     * or with status {@code 500 (Internal Server Error)} if the thumbnail couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Thumbnail> updateThumbnail(@Valid @RequestBody Thumbnail thumbnail) {
        log.debug("REST request to update Thumbnail : {}", thumbnail);
        Thumbnail result = entityService.update(thumbnail);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /thumbnail} : get all the thumbnails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of thumbnail in body.
     */

    @GetMapping()
    public ResponseEntity<List<Thumbnail>> getAllThumbnail() {
	    log.debug("REST request to get all thumbnails");
        List<Thumbnail> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /thumbnail/:id} : get the "id" thumbnail.
     *
     * @param id the id of the thumbnail to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the thumbnail, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Thumbnail> getThumbnail(@PathVariable String id) {
        log.debug("REST request to get Thumbnail : {}", id);
        Thumbnail e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /thumbnail/:id} : delete the "id" thumbnail.
     *
     * @param id the id of the thumbnail to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThumbnail(@PathVariable String id) {
        log.debug("REST request to delete Thumbnail : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
