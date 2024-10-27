package com.silo.backend.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silo.backend.service.ComponentService;
import com.silo.backend.domain.model.entity.Component;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * REST controller for managing {@link Component}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/application")
@Tag(name = "Application API", description="Uygulama islemleri")
@AllArgsConstructor
@Slf4j
public class ComponentController {
    
    private ComponentService service;

    /**
     * {@code GET  /component} : get all the component.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of component in body.
     */
    @GetMapping()
    @Operation(summary="Get all components", description="Returns all components")
    public ResponseEntity<List<Component>> getAll (){
        log.debug("REST request to getAll components");

        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    /**
     * {@code GET  /component/:id} : get the "id" component.
     *
     * @param id the id of the component to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the component, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    @Operation(summary="Get an component", description="Returns an component")
    public ResponseEntity<Component> get (@PathVariable String id){
        log.debug("REST request to get component : {}",id);

        return new ResponseEntity<>(service.get(id).orElseThrow(),HttpStatus.OK);
    }
}
