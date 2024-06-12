package com.example.uade.tpoDatos.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.Producto;
import java.util.List;


public interface CarritoRepository extends CassandraRepository<Carrito, Long>{
    
    @Query("SELECT * FROM carrito WHERE producto=?0 ALLOW FILTERING")
    Carrito findByNombreProducto(String nombreProducto);
}
