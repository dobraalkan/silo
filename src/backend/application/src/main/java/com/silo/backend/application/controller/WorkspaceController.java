package com.silo.backend.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.silo.backend.domain.model.entity.Workspace;
import com.silo.backend.service.WorkspaceService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing {@link Workspace}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/workspace")
@Tag(name = "Workspace API", description = "Structurizr workspace islemleri")
@RequiredArgsConstructor
@Slf4j
public class WorkspaceController {

    private final WorkspaceService entityService;

    /**
     * {@code POST  /workspace} : Create a new Workspace.
     *
     * @param workspace the Workspace to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Workspace.
     */
	@PostMapping()
	public ResponseEntity<Workspace> createWorkspace(@RequestBody @Valid Workspace workspace) {
         log.debug("REST request to save workspace : {}", workspace);
         //entityService.create(workspace);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /workspace} : Updates an existing workspace.
     *
     * @param workspace the workspace to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workspace,
     * or with status {@code 400 (Bad Request)} if the workspace is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workspace couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Workspace> updateWorkspace(@Valid @RequestBody Workspace workspace) {
        log.debug("REST request to update workspace : {}", workspace);
        //Workspace result = entityService.update(workspace);
        //return ResponseEntity.ok().body(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /workspace} : get all the workspace.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workspace in body.
     */
    @GetMapping()
    public ResponseEntity<List<Workspace>> getAllWorkspace() {
	    log.debug("REST request to get all workspace");
        //List<Workspace> lst = entityService.findAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /workspace/:id} : get the "id" workspace.
     *
     * @param id the id of the workspace to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workspace, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Workspace> getWorkspace(@PathVariable Long id) {
        log.debug("REST request to get workspace : {}", id);
        //Workspace e = entityService.findById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /workspace/:id} : delete the "id" workspace.
     *
     * @param id the id of the workspace to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        log.debug("REST request to delete workspace : {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}