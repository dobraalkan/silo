
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.User;
import com.silo.backend.service.UserService;


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
 * REST controller for managing {@link User}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
	
    private final UserService entityService;

 	public UserController (UserService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /user} : Create a new user.
     *
     * @param user the user to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new user.
     */
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
         log.debug("REST request to save User : {}", user);
         return new ResponseEntity<>(entityService.create(user), HttpStatus.CREATED);
    }

   	/**
     * {@code PUT  /user} : Updates an existing user.
     *
     * @param user the user to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated user,
     * or with status {@code 400 (Bad Request)} if the user is not valid,
     * or with status {@code 500 (Internal Server Error)} if the user couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.debug("REST request to update User : {}", user);
        User result = entityService.update(user);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /user} : get all the users.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of user in body.
     */

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
	    log.debug("REST request to get all users");
        List<User> lst = entityService.findAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /user/:id} : get the "id" user.
     *
     * @param id the id of the user to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the user, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        log.debug("REST request to get User : {}", id);
        User e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

  	/**
     * {@code DELETE  /user/:id} : delete the "id" user.
     *
     * @param id the id of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.debug("REST request to delete User : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
