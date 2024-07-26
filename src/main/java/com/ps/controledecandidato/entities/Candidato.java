package com.ps.controledecandidato.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "candidados")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    private String experiencia;
    private String escolaridade;
    private String genero;
    private String dataNascimento;
    @NotNull
    @Min(0)
    private Double pretensaoSalarial;

    public Candidato() {
    }

    public Candidato(String nome, String email, String telefone, String experiencia, String escolaridade, String genero, String dataNascimento, Double pretensaoSalarial) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.experiencia = experiencia;
        this.escolaridade = escolaridade;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.pretensaoSalarial = pretensaoSalarial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank String telefone) {
        this.telefone = telefone;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull Double getPretensaoSalarial() {
        return pretensaoSalarial;
    }

    public void setPretensaoSalarial(@NotNull Double pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }
}
