package com.example.uade.tpoDatos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Pedidos")
public class Pedido {
    
    @Id
    private Long id;

    private String nombre;
    private String metodoPago;
    private double total;
    private String direccion;
}
