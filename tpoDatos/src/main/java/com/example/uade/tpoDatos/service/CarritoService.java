package com.example.uade.tpoDatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uade.tpoDatos.controllers.UserController;
import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.CarritoUsuario;
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
    public ResponseEntity<String> agregarACarrito(CarritoUsuario carritoUsuario) {
        
        Carrito carritoExistente = carritoRepository.findByNombreProducto(carritoUsuario.getProducto());
        
        if(carritoExistente == null){
            try {
                Carrito carritoNuevo = new Carrito();
                carritoNuevo.setId(carritoUsuario.getId());
                carritoNuevo.setCantidad(carritoUsuario.getCantidad());
                carritoNuevo.setProducto(carritoUsuario.getProducto());
                carritoNuevo.setNombreUsuario(UserController.getUsuarioActivo().getNombre());
                carritoRepository.save(carritoNuevo);
                return new ResponseEntity<String>("Producto agregado al carrito!", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error al guardar el producto en el carrito", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
            if(productoRepository.findByNombre(carritoExistente.getProducto()) != null){
                try {
                    carritoExistente.setCantidad(carritoExistente.getCantidad() + carritoUsuario.getCantidad());
                    carritoRepository.save(carritoExistente);
                    return new ResponseEntity<String>("Cantidad de producto actualizada",HttpStatus.ACCEPTED);
                } catch (Exception e) {
                    return new ResponseEntity<String>("Error al actualizar la cantidad", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            else{
                return new ResponseEntity<String>("El producto no existe", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @Override
    public ResponseEntity<String> eliminarDeCarrito(String nombreProducto) {
        List<Carrito> elementosCarrito = carritoRepository.findAll();
        for(Carrito c: elementosCarrito){
            if(c.getNombreUsuario().equals(UserController.getUsuarioActivo().getNombre()) && c.getProducto().equals(nombreProducto)){
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
