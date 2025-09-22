package com.br.enotas.prof.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id @GeneratedValue private Long id;
    private String email;
    private String password;
    private String name;
}
