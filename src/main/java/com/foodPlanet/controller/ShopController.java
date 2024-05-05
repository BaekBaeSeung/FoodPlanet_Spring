package com.foodPlanet.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodPlanet.entity.Shop;
import com.foodPlanet.service.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/insert")
    public ResponseEntity<Shop> create (@RequestBody Shop shop){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(shopService.save(shop));
    }

    @GetMapping("/load")
    public ResponseEntity<?> readAllShops() {

        List<Shop> shops = StreamSupport
                .stream(shopService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        if(shops.isEmpty()) {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<String>("[]",headers, HttpStatus.BAD_REQUEST);

        }else return ResponseEntity.status(HttpStatus.OK).body(shops);

    }

    @GetMapping("/readEightShops")
    public ResponseEntity<?> readEightShops() {
        List<Shop> allShops = (List<Shop>) shopService.findAll();

        if (allShops.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<String>("[]", headers, HttpStatus.BAD_REQUEST);
        } else {
            // Randomly select 8 shops
            List<Shop> shuffledShops = new ArrayList<>(allShops);
            Collections.shuffle(shuffledShops);
            List<Shop> selectedShops = shuffledShops.subList(0, 8);

            return ResponseEntity.status(HttpStatus.OK).body(selectedShops);
        }
    }
    @GetMapping("/readSixShops")
    public ResponseEntity<?> readSixShops() {
        List<Shop> allShops = (List<Shop>) shopService.findAll();

        if (allShops.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<String>("[]", headers, HttpStatus.BAD_REQUEST);
        } else {
            // Randomly select 8 shops
            List<Shop> shuffledShops = new ArrayList<>(allShops);
            Collections.shuffle(shuffledShops);
            List<Shop> selectedShops = shuffledShops.subList(0, 6);

            return ResponseEntity.status(HttpStatus.OK).body(selectedShops);
        }
    }

}