package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.requestDto.CategorieRequestDto;

import java.util.List;

public interface CategorieServiceDec {
    List<Categorie> getAll();
    Categorie getById(String id);
    void delete(String id);
    Categorie addCategorie(CategorieRequestDto cat);
}
