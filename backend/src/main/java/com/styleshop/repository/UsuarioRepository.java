package com.styleshop.repository;

import com.styleshop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
