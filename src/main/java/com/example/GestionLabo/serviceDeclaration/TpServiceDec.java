package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.requestDto.TpRequestDto;

import java.util.List;

public interface TpServiceDec {
    List<Tp> getAllTp();

    Tp getTpById(String id);

    Tp saveTp(TpRequestDto tp);

    void deleteTp(String id);

}
