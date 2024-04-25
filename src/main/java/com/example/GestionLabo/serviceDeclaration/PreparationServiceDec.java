package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.requestDto.PreparationRequestDto;

import java.util.List;

public interface PreparationServiceDec {
    List<Preparation> getAllPreparations();
    Preparation getPreparationById(String id);
    Preparation savePreparation(PreparationRequestDto preparation);
    void deletePreparation(String id);
}
