package com.example.uade.tpoDatos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.uade.tpoDatos.entity.Producto;

@Service
public class ProductoService {

   
    public ResponseEntity<String> crearProducto(Producto prod) {
        
        return entity;
    }
    
    public ResponseEntity<String> getProducto(String nombre) {
        return new String();
    }
    
}
