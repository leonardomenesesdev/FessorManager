package com.br.enotas.prof.repository;

import com.br.enotas.prof.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByAlunoId(Long alunoId);
}
