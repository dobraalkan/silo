
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.Role;
import com.silo.backend.service.RoleService;
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
 * REST controller for managing {@link Role}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final Logger log = LoggerFactory.getLogger(RoleController.class);
	
    private final RoleService entityService;

 	public RoleController (RoleService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /role} : Create a new role.
     *
     * @param role the role to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new role.
     */
	@PostMapping()
	public ResponseEntity<Role> createRole(@RequestBody @Valid Role role) {
         log.debug("REST request to save Role : {}", role);
         return new ResponseEntity<>(entityService.create(role), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /role} : Updates an existing role.
     *
     * @param role the role to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated role,
     * or with status {@code 400 (Bad Request)} if the role is not valid,
     * or with status {@code 500 (Internal Server Error)} if the role couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Role> updateRole(@Valid @RequestBody Role role) {
        log.debug("REST request to update Role : {}", role);
        Role result = entityService.update(role);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /role} : get all the roles.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of role in body.
     */

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRole() {
	    log.debug("REST request to get all roles");
        List<Role> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /role/:id} : get the "id" role.
     *
     * @param id the id of the role to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the role, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getRole(@PathVariable String id) {
        log.debug("REST request to get Role : {}", id);
        Role e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /role/:id} : delete the "id" role.
     *
     * @param id the id of the role to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        log.debug("REST request to delete Role : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
