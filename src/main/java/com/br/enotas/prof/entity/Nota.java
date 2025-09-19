package com.br.enotas.prof.entity;

import jakarta.persistence.*;

@Entity
public class Nota {
    @Id @GeneratedValue private Long id;
    private double nota;
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
}
