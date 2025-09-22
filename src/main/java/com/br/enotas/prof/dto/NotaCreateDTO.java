package com.br.enotas.prof.dto;

public record NotaCreateDTO(
        Double valor,
        String disciplina,
        Long alunoId
) {
}
