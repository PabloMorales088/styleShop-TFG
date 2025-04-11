package com.styleshop.repository;

import com.styleshop.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    List<Favorito> findByUsuarioId(Long usuarioId);

    boolean existsByUsuarioIdAndProductoId(Long usuarioId, Long productoId);
}
