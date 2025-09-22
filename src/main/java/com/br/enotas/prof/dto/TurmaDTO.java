package com.br.enotas.prof.dto;

import java.util.List;

public record TurmaDTO(
        Long id,
        String nome,
        List<AlunoDTO> alunos,
        List<ProfessorDTO> professores
) {
}
