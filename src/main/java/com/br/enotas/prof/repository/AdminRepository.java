package com.br.enotas.prof.repository;

import com.br.enotas.prof.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional <Admin> findByEmail(String email);
    boolean existsByEmail(String email);
}
