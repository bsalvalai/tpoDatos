package com.example.uade.tpoDatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.repository.CarritoRepository;
import com.example.uade.tpoDatos.repository.ProductoRepository;
import com.example.uade.tpoDatos.service.interfaces.CarritoServiceImpl;

@Service
public class CarritoService implements CarritoServiceImpl{

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ResponseEntity<String> agregarACarrito(Carrito carrito) {
        Carrito carritoExsistente = carritoRepository.findByNombreProducto(carrito.getProducto());

        if(carritoExsistente == null){
            try {
                carritoRepository.save(carrito);
                return new ResponseEntity<String>("Producto agregado al carrito!", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error al guardar el producto en el carrito", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
            if(productoRepository.findByNombre(carrito.getProducto()).equals(carrito)){
                try {
                    carritoExsistente.setCantidad(carritoExsistente.getCantidad() + carrito.getCantidad());
                    carritoRepository.save(carritoExsistente);
                    return new ResponseEntity<String>("Cantidad de producto actualizada",HttpStatus.ACCEPTED);
                } catch (Exception e) {
                    return new ResponseEntity<String>("Error al actualizar la cantidad", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return new ResponseEntity<String>("El producto no existe", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> eliminarDeCarrito(String nombreProducto) {
        List<Carrito> elementosCarrito = carritoRepository.findAll();
        for(Carrito c: elementosCarrito){
            if(c.getProducto().equals(nombreProducto)){
                try {
                    carritoRepository.delete(c);
                    return new ResponseEntity<String>("Producto eliminado del carrito con exito", HttpStatus.ACCEPTED);
                } catch (Exception e) {
                    return new ResponseEntity<>("Error al eliminar producto del carrito", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new ResponseEntity<String>("No se encontro el producto en el carrito", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Carrito> getProductosCarrito() {
        return carritoRepository.findAll();
    }
    
}
