package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Tp;

import java.util.List;

public interface TpServiceDec {
    List<Tp> getAllPreparations();

    Tp getTpById(String id);

    Tp saveTp(Tp tp);

    void deleteTp(String id);

}
