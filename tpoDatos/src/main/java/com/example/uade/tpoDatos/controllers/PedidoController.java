package com.example.uade.tpoDatos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.uade.tpoDatos.entity.PedidoUsuario;
import com.example.uade.tpoDatos.service.PedidoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedido(@RequestBody PedidoUsuario pedidoUsuario) {
        return pedidoService.crearPedido(pedidoUsuario);
    }
    
}
