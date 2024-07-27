package com.ps.controledecandidato.controller;

import com.ps.controledecandidato.entities.Candidato;
import com.ps.controledecandidato.repository.CandidatoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
@Tag(name = "candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository repository;

    @Operation(summary = "Criar um novo candidato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public Candidato criarCandidato(@RequestBody @Valid Candidato candidato) {
        return repository.save(candidato);
    }

    @Operation(summary = "Obter todos os candidatos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todos os candidatos"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping
    public Iterable<Candidato> obterCandidatos() {
        return repository.findAll();
    }

    @Operation(summary = "Obter um candidato por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato encontrado"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    })
    @GetMapping("/{id}")
    public Candidato obterCandidatoPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @Operation(summary = "Obter candidatos selecionados para entrevista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de candidatos selecionados"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/candidatosselecionados")
    public Iterable<Candidato> obterCandidatosSelecionados() {
        List<Candidato> candidatosSelecionados = new ArrayList<>();
        for (Candidato candidato : repository.findAll()) {
            String situacao = candidato.getSituacao();
            if ("LIGAR PARA O CANDIDATO".equals(situacao) ||
                    "LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA".equals(situacao)) {
                candidatosSelecionados.add(candidato);
            }
            if (candidatosSelecionados.size() >= 5) {
                break;
            }
        }
        return candidatosSelecionados;
    }

    @Operation(summary = "Atualizar um candidato existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    })
    @PutMapping("/{id}")
    public Candidato atualizarCandidato(@PathVariable Long id, @RequestBody @Valid Candidato candidatoAtualizado) {
        return repository.findById(id)
                .map(candidatoExistente -> {
                    candidatoExistente.setNome(candidatoAtualizado.getNome());
                    candidatoExistente.setEmail(candidatoAtualizado.getEmail());
                    candidatoExistente.setTelefone(candidatoAtualizado.getTelefone());
                    candidatoExistente.setExperiencia(candidatoAtualizado.getExperiencia());
                    candidatoExistente.setEscolaridade(candidatoAtualizado.getEscolaridade());
                    candidatoExistente.setGenero(candidatoAtualizado.getGenero());
                    candidatoExistente.setDataNascimento(candidatoAtualizado.getDataNascimento());
                    candidatoExistente.setPretensaoSalarial(candidatoAtualizado.getPretensaoSalarial());
                    return repository.save(candidatoExistente);
                })
                .orElse(null);
    }

    @Operation(summary = "Deletar um candidato existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    })
    @DeleteMapping("/{id}")
    public void deletarCandidato(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
