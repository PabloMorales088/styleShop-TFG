package com.styleshop.service;

import com.styleshop.dto.FavoritoDTO;
import com.styleshop.mapper.FavoritoMapper;
import com.styleshop.model.Favorito;
import com.styleshop.model.Producto;
import com.styleshop.model.Usuario;
import com.styleshop.repository.FavoritoRepository;
import com.styleshop.repository.ProductoRepository;
import com.styleshop.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    private Usuario getUsuario() {
        return usuarioRepository.findById(1L).orElseThrow(); // temporal
    }

    public List<FavoritoDTO> listarFavoritos() {
        return favoritoRepository.findByUsuarioId(getUsuario().getId()).stream()
                .map(FavoritoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FavoritoDTO agregarFavorito(FavoritoDTO dto) {
        Usuario usuario = getUsuario();
        Producto producto = productoRepository.findById(dto.getProductoId()).orElseThrow();

        // (Opcional) evitar duplicados
        boolean yaExiste = favoritoRepository.existsByUsuarioIdAndProductoId(usuario.getId(), producto.getId());
        if (yaExiste) {
            return null; // o lanza excepción, o simplemente ignora
        }

        Favorito favorito = FavoritoMapper.toEntity(dto, usuario, producto);
        return FavoritoMapper.toDTO(favoritoRepository.save(favorito));
    }

    public void eliminarFavorito(Long id) {
        favoritoRepository.deleteById(id);
    }
}
