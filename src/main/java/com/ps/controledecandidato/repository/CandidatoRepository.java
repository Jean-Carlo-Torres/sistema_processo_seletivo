package com.ps.controledecandidato.repository;

import com.ps.controledecandidato.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
