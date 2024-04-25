package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.repository.TpRepo;
import com.example.GestionLabo.serviceDeclaration.TpServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TpServiceImp implements TpServiceDec {
    private final TpRepo tpRepo;

    @Override
    public List<Tp> getAllPreparations() {

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
    public Tp saveTp(Tp tp) {

        return this.tpRepo.save(tp);
    }

    @Override
    public void deleteTp(String id) {

        this.tpRepo.deleteById(id);
    }



}
