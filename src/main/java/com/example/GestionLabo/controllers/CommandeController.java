package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Commande;
import com.example.GestionLabo.requestDto.CommandeRequestDto;
import com.example.GestionLabo.serviceDeclaration.CommadeServiceDec;
import com.example.GestionLabo.serviceImplementation.CommandeServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeServiceImp commandeServiceImp;
    @GetMapping("")
    public List<Commande> getAllCommandes(){
        return commandeServiceImp.getAllCommandes();
    }

    @DeleteMapping("{id}")
    public  void deletecommande(@PathVariable("id") String idCommand){
        commandeServiceImp.deleteCommmande(idCommand);
    }

    @PostMapping("")
    public Commande saveCommande(@RequestBody CommandeRequestDto commandeRequestDto){
        return commandeServiceImp.saveCommande(commandeRequestDto);
    }
}
