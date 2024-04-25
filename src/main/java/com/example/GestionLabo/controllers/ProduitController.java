package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Produit;
import com.example.GestionLabo.models.ProduitRequestDto;
import com.example.GestionLabo.serviceImplementation.ProduitServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")


public class ProduitController {
    private final com.example.GestionLabo.serviceImplementation.ProduitServiceImp ProduitServiceImp;


    @PostMapping("")

    public ResponseEntity<Produit> saveProduct(@RequestBody() ProduitRequestDto produit) {
        Produit product = ProduitServiceImp.saveProduct(produit);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")

    public ResponseEntity<List<Produit>> getAllProducts() {
        List<Produit> allproducts = ProduitServiceImp.getAllProducts();
        return ResponseEntity.ok(allproducts);
    }

    @GetMapping("one/{id}")

    public ResponseEntity<Produit> getProductById(String id) {
        Produit produit = ProduitServiceImp.getProductById(id);
        return ResponseEntity.ok(produit);
    }

    @DeleteMapping("{id}")

    public void deleteProduct(String id) {

        ProduitServiceImp.deleteProduct(id);
    }

    /* @PutMapping("") */
    public Produit modifieProuct(Produit produit) {

        return ProduitServiceImp.modifieProuct(produit);
    }

}
