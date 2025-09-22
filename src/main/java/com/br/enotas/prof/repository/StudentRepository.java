package com.br.enotas.prof.repository;

import com.br.enotas.prof.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAlunosByTurmaId(Long id);
}
