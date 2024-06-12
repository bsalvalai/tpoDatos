package com.example.uade.tpoDatos.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.CarritoUsuario;

public interface CarritoServiceImpl {

    public ResponseEntity<String> agregarACarrito(CarritoUsuario carritoUsuario);
    
    public ResponseEntity<String> eliminarDeCarrito(String nombreProducto);

    public List<Carrito> getProductosCarrito();
}
