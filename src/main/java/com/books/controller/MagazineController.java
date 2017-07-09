package com.books.controller;


import com.books.entity.Magazine;
import com.books.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @PostMapping("/magazine")
    public List<Magazine> saveMagazine(@RequestBody Magazine magazine) throws Exception {
        magazineService.save(magazine);
        return magazineService.findAll();
    }

    @GetMapping("/magazine")
    public List<Magazine> loadMagazines(){
        return magazineService.findAll();
    }

    @DeleteMapping("/magazine")
    public List<Magazine> deleteMagazine(@RequestBody String idMagazine) {
        magazineService.delete(Integer.valueOf(idMagazine));

        return magazineService.findAll();
    }

    @PutMapping("/magazine")
    public List<Magazine> updateMagazine(@RequestBody String info) {
        magazineService.update(info);
        return magazineService.findAll();
    }



}










