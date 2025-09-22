package com.br.enotas.prof.dto;

import java.util.List;

public record TurmaCreate(
        String nome,
        List<AlunoDTO> alunos,
        List<ProfessorDTO> professores
) {

}
