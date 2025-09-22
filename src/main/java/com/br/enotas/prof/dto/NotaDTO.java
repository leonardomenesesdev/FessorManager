package com.br.enotas.prof.dto;

public record NotaDTO(
        Long id,
        double nota,
        AlunoDTO aluno,
        DisciplinaDTO disciplina,
        ProfessorDTO professor
) {
}
