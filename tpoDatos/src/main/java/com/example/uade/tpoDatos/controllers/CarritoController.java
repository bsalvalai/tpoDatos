package com.example.uade.tpoDatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.CarritoUsuario;
import com.example.uade.tpoDatos.service.CarritoService;

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
    public ResponseEntity<String> agregarACarrito(@RequestBody CarritoUsuario carritoUsuario) {
        if(UserController.getUsuarioActivo() != null){
            return carritoService.agregarACarrito(carritoUsuario);
        }
        return new ResponseEntity<>("Necesita loguearse para puder agregar productos al carrito!", HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarDeCarrito(@RequestParam String nombreProducto){
        if(UserController.getUsuarioActivo() != null){
            return carritoService.eliminarDeCarrito(nombreProducto);
        }
        return new ResponseEntity<>("Necesita loguearse para poder eliminar productos del carrito!", HttpStatus.BAD_REQUEST);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getCarrito")
    public ResponseEntity<List<Carrito>> getProductosCarrito() {
        return new ResponseEntity(carritoService.getProductosCarrito(), HttpStatus.OK);
    }
    
}
