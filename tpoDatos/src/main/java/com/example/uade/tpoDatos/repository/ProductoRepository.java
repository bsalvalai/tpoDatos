package com.example.uade.tpoDatos.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.example.uade.tpoDatos.entity.Producto;
import java.util.List;


public interface ProductoRepository extends CassandraRepository<Producto,Long>{

    @Query("SELECT * FROM productos WHERE nombre=?0 ALLOW FILTERING")
    Producto findByNombre(String nombre);
}
