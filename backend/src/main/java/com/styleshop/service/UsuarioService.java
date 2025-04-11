package com.styleshop.service;

import com.styleshop.dto.UsuarioDTO;
import com.styleshop.model.Usuario;
import com.styleshop.repository.UsuarioRepository;
import com.styleshop.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public String registrar(UsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            return "El correo ya está registrado.";
        }
        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuarioRepository.save(usuario);
        return "Usuario registrado correctamente.";
    }

    public String iniciarSesion(UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
        if (usuario == null) {
            return "Usuario no encontrado.";
        }
        if (!usuario.getContraseña().equals(dto.getContraseña())) {
            return "Contraseña incorrecta.";
        }
        return "Inicio de sesión correcto.";
    }
}

