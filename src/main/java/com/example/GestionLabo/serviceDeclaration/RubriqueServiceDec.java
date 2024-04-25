package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Rubrique;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.RubriqueRequestDto;
import com.example.GestionLabo.responseDto.RegisterUserResponseDto;

import java.util.List;

public interface RubriqueServiceDec {
    List<Rubrique> getAll();

    Rubrique getRubriqueById(String id);

    void deleteRubrique(String id);

    Rubrique addRubrique(RubriqueRequestDto rub);

}
