package com.br.enotas.prof.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Turma {
    @Id @GeneratedValue private int id;
    private String nome;
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
    @ManyToMany
    @JoinTable(
            name = "turma_professor",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professores;
}
