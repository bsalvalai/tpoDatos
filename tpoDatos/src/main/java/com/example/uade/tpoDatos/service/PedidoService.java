package com.example.uade.tpoDatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uade.tpoDatos.controllers.UserController;
import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.Pedido;
import com.example.uade.tpoDatos.entity.PedidoUsuario;
import com.example.uade.tpoDatos.entity.Producto;
import com.example.uade.tpoDatos.entity.User;
import com.example.uade.tpoDatos.repository.CarritoRepository;
import com.example.uade.tpoDatos.repository.PedidoRepository;
import com.example.uade.tpoDatos.repository.ProductoRepository;
import com.example.uade.tpoDatos.service.interfaces.PedidoServiceImpl;

@Service
public class PedidoService implements PedidoServiceImpl {


    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ResponseEntity<String> crearPedido(PedidoUsuario pedidoUsuario) {
        User usuario = UserController.getUsuarioActivo();
        if(usuario != null){
            Pedido pedido = new Pedido();
            pedido.setId(pedidoUsuario.getId());
            pedido.setMetodoPago(pedidoUsuario.getMetodoPago());
            pedido.setNombre(usuario.getNombre());
            List<Carrito> carritoUsuario = carritoRepository.findAll();
            double total = 0f;
            for(Carrito c: carritoUsuario){
                int cant = c.getCantidad();
                Producto producto = productoRepository.findByNombre(c.getProducto());
                total = total + (cant * producto.getPrecio());
            }
            pedido.setTotal(total);
            try {
                pedidoRepository.save(pedido);
                return new ResponseEntity<>("Pedido agregado con exito!", HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error al cargar pedido", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>("Iniciar sesion para ver el pedido", HttpStatus.CONFLICT);
        
    }
    
}
