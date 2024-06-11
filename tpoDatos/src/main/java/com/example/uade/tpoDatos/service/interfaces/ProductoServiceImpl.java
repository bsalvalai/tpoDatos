package com.example.uade.tpoDatos.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Producto;

public interface ProductoServiceImpl {

    public ResponseEntity<String> crearProducto(Producto prod);

    public ResponseEntity<String> getProducto(String nombre);
}
