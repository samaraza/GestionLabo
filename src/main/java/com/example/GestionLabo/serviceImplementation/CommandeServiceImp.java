package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Commande;
import com.example.GestionLabo.repository.CommandeRepo;
import com.example.GestionLabo.requestDto.CommandeRequestDto;
import com.example.GestionLabo.serviceDeclaration.CommadeServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImp  implements CommadeServiceDec {
    private final CommandeRepo commandeRepo;
    @Override
    public List<Commande> getAllCommandes() {

        return commandeRepo.findAll();
    }

    @Override
    public void deleteCommmande(String idCommande) {
        if (!this.commandeRepo.existsById(idCommande)) {
            throw new CustomNotFoundException("commande", idCommande);
        }
        this.commandeRepo.deleteById(idCommande);

    }

    @Override
    public Commande saveCommande(CommandeRequestDto commandeRequestDto) {
        Commande commande = Commande.builder()
                .designation(commandeRequestDto.getDesignation())
                .Date(commandeRequestDto.getDate())
                .observation(commandeRequestDto.getObservation())
                .numero(commandeRequestDto.getNumero())
                .produitCommandes(commandeRequestDto.getProduitCommandes())
                .build();
        return   this.commandeRepo.save(commande) ;
    }
}
