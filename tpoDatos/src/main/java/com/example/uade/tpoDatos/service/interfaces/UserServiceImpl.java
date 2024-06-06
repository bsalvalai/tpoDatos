package com.example.uade.tpoDatos.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.example.uade.tpoDatos.entity.Login;
import com.example.uade.tpoDatos.entity.User;

public interface UserServiceImpl {

    public ResponseEntity<String> crearUsuario(User user);

    public ResponseEntity<String> loguearUsuario(Login login);
    
}
