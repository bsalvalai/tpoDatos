package com.example.uade.tpoDatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.service.CarritoService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/agregar")
    public ResponseEntity<String> postMethodName(@RequestBody Carrito carrito) {
        return carritoService.agregarACarrito(carrito);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarDeCarrito(@RequestParam String nombreProducto){
        return carritoService.eliminarDeCarrito(nombreProducto);
    }
    
    @GetMapping("/getCarrito")
    public List<Carrito> getProductosCarrito() {
        return carritoService.getProductosCarrito();
    }
    
}
