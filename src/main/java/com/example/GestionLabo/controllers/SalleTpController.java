package com.example.GestionLabo.controllers;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.repository.LaboRepo;
import com.example.GestionLabo.repository.SalleTpRepo;
import com.example.GestionLabo.requestDto.SalleTpRequestDto;
import com.example.GestionLabo.serviceDeclaration.SalleTpServiceDec;
import com.example.GestionLabo.serviceImplementation.SalleTpServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("SalleTp")
public class SalleTpController {
    private final SalleTpServiceImp salleTpServiceImp;

    @GetMapping("")
    public List<SalleTp> getAllSalleTps(){

        return salleTpServiceImp.getAllSalleTps();
    }
    @GetMapping("/one/{id}")
    public SalleTp getSalleTpById(@PathVariable String id){

        return salleTpServiceImp.getSalleTpById(id);
    }
    @DeleteMapping("{id}")
    public void deleteSalleTp(@PathVariable String id) {
        salleTpServiceImp.deleteSalleTp(id);

    }
    @PostMapping("/addSalleTp")
    public SalleTp saveSalleTp(@RequestBody SalleTpRequestDto salleTpRequestDto) {
        return salleTpServiceImp.saveSalleTp(salleTpRequestDto);
    }

}
