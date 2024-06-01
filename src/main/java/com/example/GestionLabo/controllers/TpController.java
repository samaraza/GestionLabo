package com.example.GestionLabo.controllers;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.repository.TpRepo;
import com.example.GestionLabo.requestDto.TpRequestDto;
import com.example.GestionLabo.serviceDeclaration.TpServiceDec;
import com.example.GestionLabo.serviceImplementation.TpServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tp")
public class TpController  {
    private final TpServiceImp tpServiceImp;
    @GetMapping("/all")
    public List<Tp> getAllPreparations() {

        return tpServiceImp.getAllTp();
    }

    @GetMapping("/one/{id}")

    public Tp getTpById(@PathVariable() String id) {

        return tpServiceImp.getTpById(id);
    }

    @PostMapping("")

    public Tp saveTp(@RequestBody() TpRequestDto tp) {

        return tpServiceImp.saveTp(tp);
    }

    @DeleteMapping("/{id}")

    public void deleteTp(@PathVariable() String id) {

        tpServiceImp.deleteTp(id);
    }









}
