package com.qa.wine.controller;

import com.qa.wine.domain.WineList;
import com.qa.wine.service.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class WineController {

    private WineService service;

    private WineController(WineService service){
        this.service = service;
    }

//Create

    @PostMapping("/create")
    public ResponseEntity<WineList> createWine(@RequestBody WineList wine) {
        return new ResponseEntity<WineList>(this.service.create(wine), HttpStatus.CREATED);
    }
        @GetMapping("/readAll")
        public ResponseEntity<List<WineList>> readAllWine(){
            return new ResponseEntity<List<WineList>>(this.service.getAll(), HttpStatus.OK);
        }

        @GetMapping("/readById")
        public ResponseEntity<WineList>readWineById(@PathVariable long id){
        return new ResponseEntity(this.service.getById(id), HttpStatus.OK);

        }

        //Update

        @PutMapping("/update/{id}")
        public ResponseEntity<WineList> updateWine(@PathVariable long id, @RequestBody WineList wine){
          return new ResponseEntity<WineList>(this.service.update(id, wine), HttpStatus.ACCEPTED);
                  }

        // Delete

        @DeleteMapping("/delete/{id}")
            public ResponseEntity<Boolean> deleteWine(@PathVariable long id){
            return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



}
