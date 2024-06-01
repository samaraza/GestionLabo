package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.models.Produit;
import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.repository.*;
import com.example.GestionLabo.requestDto.TpRequestDto;
import com.example.GestionLabo.serviceDeclaration.TpServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TpServiceImp implements TpServiceDec {
    private final TpRepo tpRepo;
    private final UserRepo userRepo;
    private final ProduitRepo produitRepo;
    private final PreparationRepo preparationRepo;
    private final SalleTpRepo salleTpRepo;

    @Override
    public List<Tp> getAllTp() {
        return this.tpRepo.findAll();
    }

    @Override
    public Tp getTpById(String id) {
        Optional<Tp> tp = this.tpRepo.findById(id);
        if (tp.isEmpty()) {
            throw new CustomNotFoundException("tp", id);

        } else {
            return tp.get();
        }
}

    @Override
    public Tp saveTp(TpRequestDto tp) {
        Optional<SalleTp> optionalSalle = this.salleTpRepo.findById(tp.getIdSalleTp());
        SalleTp salleTp = optionalSalle.orElseThrow(() -> new CustomNotFoundException("salleTp", tp.getIdSalleTp()));
        // User prof = optionalProf.orElseThrow(() -> new CustomNotFoundException("prof", tp.getIdProf()));
        Tp newTp = new Tp();
        newTp.setManip(tp.getManip());
        newTp.setJourTp(tp.getJourTp());
        newTp.setNiveauScolaire(tp.getNiveauScolaire());
        newTp.setType(tp.getTpType());
        newTp.setSalleTp(salleTp) ;
        // newTp.setProf(prof);
        // this.userRepository.save(prof) ;
        for (String id : tp.getIdsProduit()) {
            Optional<Produit> optionalProduit = this.produitRepo.findById(id);
            Produit produit = optionalProduit.orElseThrow(() -> new CustomNotFoundException("produit", id));
            newTp.getProduits().add(produit);
            this.produitRepo.save(produit);
        }
        for (String idPreparation : tp.getIdsPrepararation()) {
            Optional<Preparation> optionalPreparation = this.preparationRepo.findById(idPreparation);
            Preparation preparation = optionalPreparation
                    .orElseThrow(() -> new CustomNotFoundException("preparation", idPreparation));
            newTp.getPreparations().add(preparation);
            this.preparationRepo.save(preparation);
        }
        return this.tpRepo.save(newTp);
    }
    @Override
    public void deleteTp(String id) {

        this.tpRepo.deleteById(id);
    }

}
