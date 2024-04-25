package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;
import org.apache.coyote.Request;

import java.util.List;

public interface ArmoireServiceDec {
    List<Armoire> getAllArmoires();
    Armoire getArmoireById(String id);
    Armoire saveArmoire(ArmoireRequestDto armoire);
     void deleteArmoire(String id);

}
