package com.example.uade.tpoDatos.service.interfaces;

import org.springframework.http.ResponseEntity;


import com.example.uade.tpoDatos.entity.PedidoUsuario;

public interface PedidoServiceImpl {
    
    public ResponseEntity<String> crearPedido(PedidoUsuario pedidoUsuario);

}
