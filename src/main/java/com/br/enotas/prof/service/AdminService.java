package com.br.enotas.prof.service;

import com.br.enotas.prof.dto.AdminDTO;
import com.br.enotas.prof.dto.AdminLoginDTO;
import com.br.enotas.prof.dto.AdminRegisterDTO;
import com.br.enotas.prof.dto.AuthResponseDTO;
import com.br.enotas.prof.entity.Admin;
import com.br.enotas.prof.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final AdminRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AdminService(AdminRepository repository, PasswordEncoder encoder, JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public AdminDTO create(AdminRegisterDTO dto) {
        if(repository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        Admin admin = new Admin();
        admin.setEmail(dto.email());
        admin.setName(dto.name());
        admin.setPassword(encoder.encode(dto.password()));
        repository.save(admin);
        return new AdminDTO(admin.getId(), admin.getEmail(), admin.getName());
    }
    public List<AdminDTO> getAll() {
        return repository.findAll().stream()
                .map(adm -> new AdminDTO(adm.getId(), adm.getName(), adm.getEmail()))
                .collect(Collectors.toList());
    }
    public AdminDTO getById(Long id){
        return repository.findById(id).map(adm -> new AdminDTO(adm.getId(), adm.getName(), adm.getEmail()))
                .orElseThrow(()-> new RuntimeException("Admin não encontrado. ID: "+ id));
    }
    public AdminDTO getByEmail(String email){
        return repository.findByEmail(email).map(adm -> new AdminDTO(adm.getId(), adm.getName(), adm.getEmail()))
                .orElseThrow(() -> new RuntimeException("Admin com email "+email+" não encontrado"));
    }
    public AdminDTO update(Long id, AdminRegisterDTO dto) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin não encontrado. ID: " + id));
        admin.setName(dto.name());
        admin.setEmail(dto.email());
        if(dto.password() != null && !dto.password().isBlank()){
            admin.setPassword(encoder.encode(dto.password()));
        }
        Admin actual = repository.save(admin);
        return new AdminDTO(actual.getId(), actual.getName(), actual.getEmail());
    }

    public void deleteById(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Admin não encontrado. ID: " + id);
        }
        repository.deleteById(id);
    }

    public AuthResponseDTO login(AdminLoginDTO dto) {
        Admin admin = repository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));

        if (!encoder.matches(dto.senha(), admin.getPassword())) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        String token = jwtService.generateToken(admin.getEmail());

        return new AuthResponseDTO(
                token,
                new AdminDTO(admin.getId(), admin.getName(), admin.getEmail())
        );
    }



}