package com.styleshop.controller;

import com.styleshop.dto.FavoritoDTO;
import com.styleshop.service.FavoritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@RequiredArgsConstructor
public class FavoritoController {

    private final FavoritoService favoritoService;

    @GetMapping
    public List<FavoritoDTO> listar() {
        return favoritoService.listarFavoritos();
    }

    @PostMapping
    public FavoritoDTO agregar(@RequestBody FavoritoDTO dto) {
        return favoritoService.agregarFavorito(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        favoritoService.eliminarFavorito(id);
    }
}
