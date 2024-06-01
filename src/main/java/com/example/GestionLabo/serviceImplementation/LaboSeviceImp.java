package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.enums.LaboType;
import com.example.GestionLabo.repository.LaboRepo;
import com.example.GestionLabo.serviceDeclaration.LaboServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaboSeviceImp implements LaboServiceDec {
    private final LaboRepo laboRepo ;
    @Override
    public List<Labo> getAllLabo() {

        return  this.laboRepo.findAll() ;
    }

    @Override
    public Labo getLaboAllById(String id) {
        Optional<Labo> laboOptional = this.laboRepo.findById(id ) ;
        Labo labo = laboOptional.orElseThrow(()->new CustomNotFoundException("labo" , id)) ;
        return  labo ;

    }

    @Override
    public void deleteLabo(String id) {
        if (!laboRepo.existsById(id)){
            throw new CustomNotFoundException("labo" , id) ;

        }
        this.laboRepo.deleteById(id);

    }

    @Override
    public Labo saveLabo(LaboType laboType) {
        Labo labo = new Labo();
        labo.setLaboType(laboType) ;

        return this.laboRepo.save(labo) ;

    }


}
