package com.example.uade.tpoDatos.entity;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("carrito")
public class Carrito {
    
    @PrimaryKey
    private Long id;

    @Column("producto")
    private String producto;

    @Column("cantidad")
    private int cantidad;

    @Column("nombre_usuario")
    private String nombreUsuario;
}
