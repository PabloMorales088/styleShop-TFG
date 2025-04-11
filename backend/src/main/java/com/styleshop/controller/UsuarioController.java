package com.styleshop.controller;

import com.styleshop.dto.UsuarioDTO;
import com.styleshop.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrar(@RequestBody UsuarioDTO dto) {
        return usuarioService.registrar(dto);
    }

    @PostMapping("/iniciar-sesion")
    public String iniciarSesion(@RequestBody UsuarioDTO dto) {
        return usuarioService.iniciarSesion(dto);
    }
}

