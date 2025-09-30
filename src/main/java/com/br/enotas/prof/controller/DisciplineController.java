package com.br.enotas.prof.controller;

import com.br.enotas.prof.dto.DisciplinaDTO;
import com.br.enotas.prof.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> create(@RequestBody DisciplinaDTO dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> getAll(){
        return ResponseEntity.ok(disciplineService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(disciplineService.getById(id));
    }
}
