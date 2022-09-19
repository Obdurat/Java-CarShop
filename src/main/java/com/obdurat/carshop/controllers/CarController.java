package com.obdurat.carshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obdurat.carshop.models.CarEntity;
import com.obdurat.carshop.models.Response;
import com.obdurat.carshop.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
    
    @Autowired
    CarService service;
    
    @PostMapping
    public ResponseEntity<Response<CarEntity>> create(@RequestBody @Validated CarEntity request) {
        CarEntity result = service.create(request);
        Response<CarEntity> response = new Response<CarEntity>(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<CarEntity>>> getAll() {
        List<CarEntity> result = service.findAll();
        Response<List<CarEntity>> response = new Response<List<CarEntity>>(result);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<CarEntity>> findById(@PathVariable String id) {
        System.out.println(id);
        CarEntity result = this.service.findOne(id);
        Response<CarEntity> response = new Response<CarEntity>(result);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<CarEntity>> update(@PathVariable String id, @RequestBody @Validated CarEntity entity) {
        CarEntity result = this.service.update(id, entity);
        Response<CarEntity> response = new Response<CarEntity>(result);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity.BodyBuilder delete(@PathVariable String id) {
        Boolean request = this.service.delete(id);
        if (!request) { return ResponseEntity.status(HttpStatus.NOT_FOUND); };
        return ResponseEntity.status(HttpStatus.ACCEPTED);
    }
}

