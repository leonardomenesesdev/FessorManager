package com.br.enotas.prof.dto;

import java.util.List;

public record AlunoRegisterDTO(
        String nome,
        TurmaDTO turma,
        List<ProfessorDTO> professores,
        List<NotaDTO> notas,
        AdminDTO admin
) { }

