package com.br.enotas.prof.repository;

import com.br.enotas.prof.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    boolean existsByNome(String nome);

}
