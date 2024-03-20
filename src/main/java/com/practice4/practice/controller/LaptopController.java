package com.practice4.practice.controller;



import com.practice4.practice.entity.Laptop;
import com.practice4.practice.service.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/laptop")
public class LaptopController {

    private LaptopService laptopService;

    public LaptopController(LaptopService laptopService){
        this.laptopService=laptopService;
    }
//     localhost:8080/laptop/
    @PostMapping("/")
    public ResponseEntity<Laptop> setLaptop(@RequestBody Laptop laptop){
        return new ResponseEntity<Laptop>(laptopService.setLaptop(laptop), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Laptop>> getAllLaptop(){
        return new ResponseEntity<List<Laptop>>(laptopService.getAllLaptop(), HttpStatus.OK);
    }






}
