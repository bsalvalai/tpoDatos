package com.example.uade.tpoDatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.repository.CarritoRepository;
import com.example.uade.tpoDatos.repository.ProductoRepository;
import com.example.uade.tpoDatos.service.interfaces.CarritoServiceImpl;

public class CarritoService implements CarritoServiceImpl {

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public ResponseEntity<String> agregarACarrito(Carrito carrito) {
        Carrito carritoExistente = carritoRepository.findById(carrito.getId());
        if(carritoExistente != null){
            try {
                carritoExistente.setCantidad(carritoExistente.getCantidad() + carrito.getCantidad());
                carritoRepository.save(carritoExistente);
                return new ResponseEntity<>("Cantidad actualizada correctamente", HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<String>("Error al actualizar cantidad", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
            System.out.println(productoRepository.findByNombre(carrito.getNombreProducto()));
            if(productoRepository.findByNombre(carrito.getNombreProducto()) != null){
                try {
                    carritoRepository.save(carrito);
                    return new ResponseEntity<String>("Producto creado correctamente", HttpStatus.CREATED);
                } catch (Exception e) {
                    return new ResponseEntity<String>("Error al crear producto", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
       return new ResponseEntity<String>("El producto no existe", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> eliminarDeCarrito(String nombreProducto) {
        for(Carrito c: carritoRepository.findAll()){
            if(c.getNombreProducto().equals(nombreProducto)){
                try {
                    carritoRepository.deleteProduct(c.getId());
                    return new ResponseEntity<String>("Producto eliminado correctamente", HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<String>("Error al eliminar producto", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new ResponseEntity<String>("No se encontro el producto", HttpStatus.NOT_FOUND);
    }

     
    
}
