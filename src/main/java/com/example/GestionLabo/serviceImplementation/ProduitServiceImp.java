package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.*;
import com.example.GestionLabo.repository.*;
import com.example.GestionLabo.serviceDeclaration.ProduitServiceDec;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitServiceImp implements ProduitServiceDec {
    private final ProduitRepo produitRepo;
    private final RubriqueRepo rubriqueRepo;
    private final CategorieRepo categorieRepo;
    private final ArmoireRepo armoireRepo ;
    private final ModelMapper modelMapper;
    private  final FournisseurRepo fournisseurRepo ;



    @Override
    public Produit saveProduct(ProduitRequestDto produitRegDto) {
        Optional<Categorie> optionalCategorie = this.categorieRepo.findById(produitRegDto.getIdCategorie()) ;
        Categorie categorie = optionalCategorie.orElseThrow(()->new CustomNotFoundException("categorie" ,produitRegDto.getIdCategorie())) ;

        Optional<Fournisseur>optionalFournisseur = this.fournisseurRepo.findById(produitRegDto.getIdFournisseur())  ;
        Fournisseur fournisseur= optionalFournisseur.orElseThrow(()->new CustomNotFoundException("Fournisseur" ,produitRegDto.getIdFournisseur()))  ;

        Optional<Armoire>optionalArmoire= this.armoireRepo.findById(produitRegDto.getIdArmoire()) ;
        Armoire armoire= optionalArmoire.orElseThrow(()->new CustomNotFoundException("Armoire" , produitRegDto.getIdArmoire()));

        Optional<Rubrique>optionalRubrique= this.rubriqueRepo.findById(produitRegDto.getIdRubrique()) ;
        Rubrique rubrique= optionalRubrique.orElseThrow(()->new CustomNotFoundException("Rubrique" ,produitRegDto.getIdRubrique()));

        Produit produit = Produit.builder()
                .armoire(armoire)
                .fournisseur(fournisseur)
                .type(produitRegDto.getType())
                .rubrique(rubrique)
                .categorie(categorie)
                .designation(produitRegDto.getDesignation())
                .reference(produitRegDto.getReference())
                .quantiteInitiale(produitRegDto.getQuantiteInitiale())
                .uniteMesure(produitRegDto.getUniteMesure())
                .build();
        Produit savedProduit = this.produitRepo.save(produit);
        categorie.getProduits().add(savedProduit);
        this.categorieRepo.save(categorie);
        rubrique.getProduits().add(savedProduit);
        this.rubriqueRepo.save(rubrique);
        armoire.getProduits().add(savedProduit);
        this.armoireRepo.save(armoire);
        return  savedProduit;


    }

    @Override
    public List<Produit> getAllProducts() {

        return this.produitRepo.findAll();
    }

    @Override
    public Produit getProductById(String id) {
        Optional<Produit> produit = this.produitRepo.findById(id);
        if (produit.isEmpty()) {
            throw new CustomNotFoundException("product", id);

        } else {
            return produit.get();
        }

    }

    @Override
    public void deleteProduct(String id) {
        if (!this.produitRepo.existsById(id)) {
            throw new CustomNotFoundException("product", id);
        }
        this.produitRepo.deleteById(id);


    }

    @Override
    public Produit modifieProuct(Produit produit) {

        Optional<Produit>existingProduitOptional =produitRepo.findById(produit.getId());
        if (existingProduitOptional.isEmpty()){
            throw new CustomNotFoundException("product", produit.getId());
        }
        Produit existingProduit = existingProduitOptional.get();
        existingProduit.setDesignation(produit.getDesignation());
        existingProduit.setReference(produit.getReference());
        existingProduit.setType(produit.getType());
        existingProduit.setQuantiteInitiale(produit.getQuantiteInitiale());
        existingProduit.setQuantiteUtilise(produit.getQuantiteUtilise());
        existingProduit.setQuantiteRestante(produit.getQuantiteRestante());
        existingProduit.setQuanitePerdu(produit.getQuanitePerdu());
        existingProduit.setUniteMesure(produit.getUniteMesure());
        if (produit.getCategorie() !=null){
            existingProduit.setCategorie(produit.getCategorie());
        }
        if (produit.getFournisseur() != null) {
            existingProduit.setFournisseur(produit.getFournisseur());
        }
        if (produit.getRubrique() != null) {
            existingProduit.setRubrique(produit.getRubrique());
        }
        if (produit.getArmoire() != null) {
            existingProduit.setArmoire(produit.getArmoire());
        }
        return produitRepo.save(existingProduit);
    }

    @Override
    public void inventaireProduit(Produit produit) {
        Optional<Produit>optionalProduit = produitRepo.findById(produit.getId()) ;
        if (optionalProduit.isPresent()) {
            Produit newProduct = optionalProduit.get() ;
            newProduct.setQuantiteRestante(produit.getQuantiteRestante());
            newProduct.setQuanitePerdu(produit.getQuanitePerdu());
            produitRepo.save(newProduct);
        }
    }


}
