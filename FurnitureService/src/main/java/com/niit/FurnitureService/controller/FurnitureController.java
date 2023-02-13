package com.niit.FurnitureService.controller;

import com.niit.FurnitureService.domain.Furniture;
import com.niit.FurnitureService.exception.FurnitureAlreadyExistsException;
import com.niit.FurnitureService.exception.FurnitureNotExistsException;
import com.niit.FurnitureService.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FurnitureController {
    @Autowired
    IFurnitureService furnitureService;

    @GetMapping("/furniture")
    public ResponseEntity<?> getAllFurnitures(){
        return new ResponseEntity<>(furnitureService.allFurnitures(), HttpStatus.OK);
    }
    @PostMapping("/savefurniture")
    public ResponseEntity<?> saveFurniture(@RequestBody Furniture furniture) throws FurnitureAlreadyExistsException {
        System.out.println(furniture);
        return new ResponseEntity<>(furnitureService.saveFurniture(furniture), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFurniture(@PathVariable String id) throws FurnitureNotExistsException {
        return new ResponseEntity<>(furnitureService.deleteFurniture(id),HttpStatus.OK);
    }

}
