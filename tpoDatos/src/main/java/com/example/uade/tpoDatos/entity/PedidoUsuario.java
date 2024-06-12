package com.example.uade.tpoDatos.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class PedidoUsuario {
    
    @Id
    private Long id;
    private String metodoPago;
}
