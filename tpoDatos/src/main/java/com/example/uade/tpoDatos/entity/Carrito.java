package com.example.uade.tpoDatos.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("carrito")
public class Carrito implements Serializable{
    
    @Id
    private int id;
    private int cantidad;
    private String nombreProducto;
}
