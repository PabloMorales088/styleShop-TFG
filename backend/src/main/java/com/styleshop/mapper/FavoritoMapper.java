package com.styleshop.mapper;

import com.styleshop.dto.FavoritoDTO;
import com.styleshop.model.Favorito;
import com.styleshop.model.Producto;
import com.styleshop.model.Usuario;

public class FavoritoMapper {

    public static Favorito toEntity(FavoritoDTO dto, Usuario usuario, Producto producto) {
        return Favorito.builder()
                .id(dto.getId())
                .usuario(usuario)
                .producto(producto)
                .build();
    }

    public static FavoritoDTO toDTO(Favorito favorito) {
        return new FavoritoDTO(
                favorito.getId(),
                favorito.getProducto().getId()
        );
    }
}
