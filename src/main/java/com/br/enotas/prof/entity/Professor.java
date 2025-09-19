package com.br.enotas.prof.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {
    @Id @GeneratedValue private Long id;
    private String nome;
    @Column(unique=true) private String email;
    private String senha;
    @ManyToMany(mappedBy = "professores") private List<Turma> turmas;
}
