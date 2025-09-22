package com.br.enotas.prof.dto;

import com.br.enotas.prof.entity.Class;

import java.util.List;

public record AlunoDTO(
        Long id,
        String nome,
        Class turma,
        List<ProfessorDTO> professores,
        List<NotaDTO> notas,
        AdminDTO admin
) {
}
