package com.example.uade.tpoDatos.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.uade.tpoDatos.entity.Producto;

public interface ProductoRepository extends CassandraRepository<Producto,Long>{
    
}