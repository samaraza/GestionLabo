package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.requestDto.CategorieRequestDto;
import com.example.GestionLabo.serviceImplementation.CategorieSeviceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Categorie")

public class CategorieController {
    private final CategorieSeviceImp categorieServiceImp;

    @GetExchange("/all")

    public List<Categorie> getAll() {

        return categorieServiceImp.getAll();
    }

    @GetMapping("/one/{id}")
    public Categorie getById(@PathVariable() String id) {

        return categorieServiceImp.getById(id);
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable() String id) {

        categorieServiceImp.delete(id);
    }

    @PostMapping("")

    public ResponseEntity<Categorie> addCategorie(CategorieRequestDto cat) {
        Categorie categorie = categorieServiceImp.addCategorie(cat);
        return ResponseEntity.ok(categorie);
    }


}
