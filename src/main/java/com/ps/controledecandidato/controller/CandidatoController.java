package com.ps.controledecandidato.controller;

import com.ps.controledecandidato.entities.Candidato;
import com.ps.controledecandidato.repository.CandidatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository repository;

    @PostMapping
    public Candidato criarCandidato(@RequestBody @Valid Candidato candidato) {
        return repository.save(candidato);
    }

    @GetMapping
    public Iterable<Candidato> obterCandidatos() {
        return repository.findAll();
    }
}
