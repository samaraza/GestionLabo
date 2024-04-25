package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.models.PreparationProduit;
import com.example.GestionLabo.repository.PreparationRepo;
import com.example.GestionLabo.requestDto.PreparationRequestDto;
import com.example.GestionLabo.serviceDeclaration.PreparationServiceDec;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PreparationServiceImp implements PreparationServiceDec {
    private final PreparationRepo preparationRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<Preparation> getAllPreparations() {

        return this.preparationRepo.findAll();
    }

    @Override
    public Preparation getPreparationById(String id) {
        Optional<Preparation> preparation = this.preparationRepo.findById(id);
        if (preparation.isEmpty()) {
            throw new CustomNotFoundException("preparation", id);
        } else {
            return preparation.get();
        }
}

    @Override
    public Preparation savePreparation(PreparationRequestDto prep) {
        Preparation preparation = new Preparation();
        List<PreparationProduit> preparationProduits = prep.getPreparationReqProduits()
                .stream()
                .map(element -> modelMapper.map(element, PreparationProduit.class))
                .collect(Collectors.toList());
        preparation.setPreparationProduits(preparationProduits);
        preparation.setDate(prep.getDate());
        preparation.setDesignation(prep.getDesignation());
        return preparationRepo.save(preparation);

}

    @Override
    public void deletePreparation(String id) {
        this.preparationRepo.deleteById(id);

    }
}
