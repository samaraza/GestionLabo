package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.enums.LaboType;
import com.example.GestionLabo.serviceImplementation.LaboSeviceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Labo")

public class LaboController {
    private  final LaboSeviceImp laboServiceImp ;



    @GetMapping("")
    public List<Labo> getAllLAbo() {

        return laboServiceImp.getAllLabo();
    }
    @GetMapping("/one/{id}")
    public Labo getLaboById(@PathVariable String id) {

        return laboServiceImp.getLaboAllById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteLabo(@PathVariable  String id) {

        laboServiceImp.deleteLabo(id);
    }
    @PostMapping("")
    public Labo saveLabo(   @RequestBody LaboType laboType) {

        return laboServiceImp.saveLabo(laboType);
    }



    @PutMapping("update/{id}")
    public void updateLabo(@PathVariable  String id, @RequestBody LaboType laboType){
         laboServiceImp.updateLabo(laboType);

    }


}
