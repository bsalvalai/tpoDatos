package com.example.uade.tpoDatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.uade.tpoDatos.entity.Producto;
import com.example.uade.tpoDatos.service.ProductoService;


@Controller
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto prod) {
        return productoService.crearProducto(prod);
    }
    
    @GetMapping("/get")
    public ResponseEntity<String> getProducto(@RequestParam String nombre) {
        return productoService.getProducto(nombre);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getProductos")
    public ResponseEntity<List<Producto>> getProductos() {
        return new ResponseEntity(productoService.getProductos(), HttpStatus.OK);
    }
    
    
}
