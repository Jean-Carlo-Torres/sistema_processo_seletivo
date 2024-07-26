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

    @GetMapping("/{id}")
    public Candidato obterCandidatoPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Candidato atualizarCandidato(@PathVariable Long id, @RequestBody @Valid Candidato candidatoAtualizado) {
        Candidato candidatoExistente = repository.findById(id).orElse(null);
        if (candidatoExistente != null) {
            candidatoExistente.setNome(candidatoAtualizado.getNome());
            candidatoExistente.setEmail(candidatoAtualizado.getEmail());
            candidatoExistente.setTelefone(candidatoAtualizado.getTelefone());
            candidatoExistente.setExperiencia(candidatoAtualizado.getExperiencia());
            candidatoExistente.setEscolaridade(candidatoAtualizado.getEscolaridade());
            candidatoExistente.setGenero(candidatoAtualizado.getGenero());
            candidatoExistente.setDataNascimento(candidatoAtualizado.getDataNascimento());
            candidatoExistente.setPretensaoSalarial(candidatoAtualizado.getPretensaoSalarial());
            return repository.save(candidatoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarCandidato(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
