package com.br.enotas.prof.repository;

import com.br.enotas.prof.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class,Long> {
    Class findTurmaById(Long id);
    Optional<Class> findTurmaByNome(String nome);
}
