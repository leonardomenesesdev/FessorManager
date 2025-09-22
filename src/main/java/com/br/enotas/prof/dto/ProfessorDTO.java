package com.br.enotas.prof.dto;

public record ProfessorDTO(
        Long id,
        String nome,
        String email,
        Enum disciplina
) {
}
