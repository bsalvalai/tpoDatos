package com.example.uade.tpoDatos.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Carrito;

public interface CarritoServiceImpl {

    public ResponseEntity<String> agregarACarrito(Carrito carrito);
    
    public ResponseEntity<String> eliminarDeCarrito(Carrito carrito);

}
