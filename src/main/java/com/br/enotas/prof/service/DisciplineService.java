package com.br.enotas.prof.service;

import com.br.enotas.prof.dto.DisciplinaCreateDTO;
import com.br.enotas.prof.dto.DisciplinaDTO;
import com.br.enotas.prof.entity.Discipline;
import com.br.enotas.prof.repository.DisciplineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DisciplineService {
    private final DisciplineRepository repository;

    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    public DisciplinaDTO create(DisciplinaCreateDTO dto){
        if (repository.existsByNome(dto.nome())){
            throw new IllegalArgumentException("Disciplina com nome já existente");
        }
        Discipline discipline = new Discipline();
        discipline.setName(dto.nome());
        repository.save(discipline);
        return new DisciplinaDTO(discipline.getId(), discipline.getName());
    }
    public List<DisciplinaDTO> getAll(){
        return repository.findAll().stream().map(
                d ->  new DisciplinaDTO(d.getId(), d.getName()))
                .collect(Collectors.toList());
    }
    public DisciplinaDTO getById(Long id){
        return repository.findById(id)
                .map(d -> new DisciplinaDTO(d.getId(), d.getName())) // converte Disciplina → DisciplinaDTO
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com id: " + id));
    }
    public DisciplinaDTO update(Long id, DisciplinaDTO dto){
        Discipline discipline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com id: " + id));
        discipline.setName(dto.nome());
        Discipline actualDiscipline = repository.save(discipline);
        return new DisciplinaDTO(actualDiscipline.getId(), actualDiscipline.getName());
    }
    public void delete(Long id){
        Discipline discipline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com id: " + id));
        repository.delete(discipline);
        System.out.println("Disciplina "+ discipline.getName()+ " deletada");
    }
}


