package com.example.uade.tpoDatos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table()
public class Producto {
    
    @Id
    private Long id;

    @Column()
    private String nombre;

    @Column()
    private String categoria;
    
    @Column()
    private double precio;

    @Column()
    private String imagen;
}
