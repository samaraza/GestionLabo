package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.enums.LaboType;

import java.util.List;

public interface LaboServiceDec {
    List <Labo> getAllLabo();
    Labo getLaboAllById(String id);
    void deleteLabo(String id);
    Labo saveLabo(LaboType laboType);
    Labo updateLabo(LaboType laboType);

    Labo updateLabo(String id);
}
