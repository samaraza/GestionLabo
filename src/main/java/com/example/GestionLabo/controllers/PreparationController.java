package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.requestDto.PreparationRequestDto;
import com.example.GestionLabo.serviceImplementation.PreparationServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("preparation")
@RequiredArgsConstructor

public class PreparationController {
    private final PreparationServiceImp preparationServiceImp;

    @GetMapping("/all")

    public List<Preparation> getAllPreparations() {

        return preparationServiceImp.getAllPreparations();
    }

    @GetMapping("/one/{id}")
    public Preparation getPreparationById(@PathVariable() String id) {
        return preparationServiceImp.getPreparationById(id);
    }

    @PostMapping("")

    public Preparation savePreparation(@RequestBody() PreparationRequestDto preparation) {
        return preparationServiceImp.savePreparation(preparation);
    }

    @DeleteMapping("{id}")

    public void deletePeparation(@PathVariable() String id) {
        preparationServiceImp.deletePreparation(id);

    }

}
