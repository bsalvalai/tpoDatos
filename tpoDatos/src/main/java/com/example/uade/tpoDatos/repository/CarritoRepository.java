package com.example.uade.tpoDatos.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.example.uade.tpoDatos.entity.Carrito;



public interface CarritoRepository extends CassandraRepository<Carrito, Long>{
    
    @Query("SELECT * FROM carrito WHERE producto=?0 ALLOW FILTERING")
    Carrito findByNombreProducto(String nombreProducto);

    @Query("SELECT * FROM carrito WHERE nombre_usuario=?0 ALLOW FILTERING")
    List<Carrito> findAllByNombreUsuario(String nombreUsuario);
}
