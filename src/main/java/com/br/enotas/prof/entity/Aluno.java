package com.br.enotas.prof.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aluno {
    @Id @GeneratedValue private int id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "turma_id") // Nome da chave estrangeira na tabela Aluno
    private Turma turma;    private List<Professor> professores;
    @OneToMany(mappedBy = "aluno")
    private List<Nota> notas;
}
