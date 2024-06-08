package com.example.uade.tpoDatos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("productos")
public class Producto {
    
    //@Id
    @PrimaryKey
    private Long id;

    @Column("nombre")
    private String nombre;

    @Column("categoria")
    private String categoria;
    
    @Column("precio")
    private double precio;

    @Column("imagen")
    private String imagen;
}
