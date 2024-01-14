
package com.silo.backend.application.controller;

import com.silo.backend.domain.model.entity.UserAgentInfo;
import com.silo.backend.service.UserAgentInfoService;

import io.swagger.v3.oas.annotations.tags.Tag;

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
 * REST controller for managing {@link UserAgentInfo}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/userAgentInfo")
@Tag(name = "book service", description = "the book API with description tag annotation")
public class UserAgentInfoController {

    private final Logger log = LoggerFactory.getLogger(UserAgentInfoController.class);

    private final UserAgentInfoService entityService;

    public UserAgentInfoController(UserAgentInfoService entityService) {
        this.entityService = entityService;
    }

    /**
     * {@code POST  /userAgentInfo} : Create a new userAgentInfo.
     *
     * @param userAgentInfo the userAgentInfo to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new userAgentInfo.
     */
    @PostMapping()
    public ResponseEntity<UserAgentInfo> createUserAgentInfo(@RequestBody @Valid UserAgentInfo userAgentInfo) {
        log.debug("REST request to save UserAgentInfo : {}", userAgentInfo);
        return new ResponseEntity<>(entityService.create(userAgentInfo), HttpStatus.CREATED);
    }

    /**
     * {@code PUT  /userAgentInfo} : Updates an existing userAgentInfo.
     *
     * @param userAgentInfo the userAgentInfo to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated userAgentInfo,
     *         or with status {@code 400 (Bad Request)} if the userAgentInfo is not
     *         valid,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         userAgentInfo couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<UserAgentInfo> updateUserAgentInfo(@Valid @RequestBody UserAgentInfo userAgentInfo) {
        log.debug("REST request to update UserAgentInfo : {}", userAgentInfo);
        UserAgentInfo result = entityService.update(userAgentInfo);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /userAgentInfo} : get all the userAgentInfos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of userAgentInfo in body.
     */

    @GetMapping()
    public ResponseEntity<List<UserAgentInfo>> getAllUserAgentInfo() {
        log.debug("REST request to get all userAgentInfos");
        List<UserAgentInfo> lst = entityService.findAll();

        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    /**
     * {@code GET  /userAgentInfo/:id} : get the "id" userAgentInfo.
     *
     * @param id the id of the userAgentInfo to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the userAgentInfo, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAgentInfo> getUserAgentInfo(@PathVariable Integer id) {
        log.debug("REST request to get UserAgentInfo : {}", id);
        UserAgentInfo e = entityService.findById(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    /**
     * {@code DELETE  /userAgentInfo/:id} : delete the "id" userAgentInfo.
     *
     * @param id the id of the userAgentInfo to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAgentInfo(@PathVariable Integer id) {
        log.debug("REST request to delete UserAgentInfo : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
