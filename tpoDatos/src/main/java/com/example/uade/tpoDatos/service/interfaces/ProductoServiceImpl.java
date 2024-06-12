package com.example.uade.tpoDatos.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Producto;

public interface ProductoServiceImpl {

    public ResponseEntity<String> crearProducto(Producto prod);

    public ResponseEntity<String> getProducto(String nombre);

    public List<Producto> getProductos();
}
