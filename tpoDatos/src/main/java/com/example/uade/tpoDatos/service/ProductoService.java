package com.example.uade.tpoDatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.uade.tpoDatos.entity.Producto;
import com.example.uade.tpoDatos.repository.ProductoRepository;
import com.example.uade.tpoDatos.service.interfaces.ProductoServiceImpl;

@Service
public class ProductoService implements ProductoServiceImpl{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CqlSession cqlSession;

   
    public ResponseEntity<String> crearProducto(Producto prod) {
        
        try {
            if (productoRepository.findByNombre(prod.getNombre()) == null) {
                productoRepository.save(prod);
                return new ResponseEntity<>("Producto creado correctamente", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("El producto ya existe", HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log para depurar el problema
            return new ResponseEntity<>("Error al crear producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public ResponseEntity<String> getProducto(String nombre) {
        List<Producto> productos = productoRepository.findAll();
        for(Producto p : productos){
            if(p.getNombre() == nombre){
                return new ResponseEntity<String>("Producto encontrado", HttpStatus.FOUND);
            }
        }
        return new ResponseEntity<String>("Error al encontrar producto", HttpStatus.NOT_FOUND);
    }

    
}
