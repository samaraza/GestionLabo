package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.repository.ArmoireRepo;
import com.example.GestionLabo.repository.SalleTpRepo;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;
import com.example.GestionLabo.serviceDeclaration.ArmoireServiceDec;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor

public class ArmoireServiceImp implements ArmoireServiceDec {

    private final ArmoireRepo armoireRepo;
    private final SalleTpRepo salleTpRepo;

    @Override
    public List<Armoire> getAllArmoires() {

        return this.armoireRepo.findAll();
    }

    @Override
    public Armoire getArmoireById(String id) {

        Optional<Armoire> optionalArmoire = this.armoireRepo.findById(id);
        if (optionalArmoire.isEmpty()) {
            throw new CustomNotFoundException("Armoire", id);
        } else {
            return optionalArmoire.get();
        }
    }

    @Override
    public Armoire saveArmoire(ArmoireRequestDto armoireRequestDto) {


        Optional<SalleTp> salleTpOptiobnal = this.salleTpRepo.findById(armoireRequestDto.getIdSalleTp());
        SalleTp salleTp = salleTpOptiobnal
                .orElseThrow(() -> new CustomNotFoundException("salleTp", armoireRequestDto.getIdSalleTp()));

        Armoire arm = new Armoire();

        arm.setSalleTp(salleTp);
        arm.setDesignation(armoireRequestDto.getDesignation());
        Armoire savedArm = this.armoireRepo.save(arm);
        salleTp.getArmoires().add(savedArm);
        this.salleTpRepo.save(salleTp);
        return savedArm;


}
    @Override
    public void deleteArmoire(String id) {
        if (!armoireRepo.existsById(id)) {
            throw new CustomNotFoundException("armoire", id);
        }
        armoireRepo.deleteById(id);
    }


}
