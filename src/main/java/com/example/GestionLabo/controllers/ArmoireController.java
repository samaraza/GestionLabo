package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;
import com.example.GestionLabo.serviceImplementation.ArmoireServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Armoire")
@RequiredArgsConstructor

public class ArmoireController {

    private  final ArmoireServiceImp armorieServiceImp;




    @GetMapping("")
    public ResponseEntity<List<Armoire>> getAllArmoires() {
        List<Armoire>allArms=  armorieServiceImp.getAllArmoires();


        return  ResponseEntity.ok(allArms);

    }
    @GetMapping("/one/{id}")

    public ResponseEntity<Armoire> getArmoireById(@PathVariable String id) {
        Armoire arm=armorieServiceImp.getArmoireById(id);
        return ResponseEntity.ok(arm) ;
    }
    @PostMapping("")

    public Armoire saveArmoire(@RequestBody() ArmoireRequestDto armoireRequestDto) {

        return armorieServiceImp.saveArmoire(armoireRequestDto);
    }
    @DeleteMapping("{id}")

    public void deleteArmoire(@PathVariable String id) {

        armorieServiceImp.deleteArmoire(id);
    }


}
