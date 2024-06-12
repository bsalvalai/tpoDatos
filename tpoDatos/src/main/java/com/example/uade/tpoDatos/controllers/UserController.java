package com.example.uade.tpoDatos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.uade.tpoDatos.entity.Login;
import com.example.uade.tpoDatos.entity.User;
import com.example.uade.tpoDatos.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {

    private static User usuarioActivo;

    @Autowired
    private UserService userService; 
    
    @PostMapping("/create")
    public ResponseEntity<String> crearUsuario(@RequestBody User user) {
        return userService.crearUsuario(user);
    }
    
    @GetMapping("/login")
    public ResponseEntity<String> loguearUsuario(@RequestBody Login login) {
        if(usuarioActivo != null){
            return new ResponseEntity<>("Ya hay un usuario logueado", HttpStatus.CONFLICT);
        }
        return userService.loguearUsuario(login);
    }

    @GetMapping("/desloguear")
    public ResponseEntity<String> desloguearUsuario() {
        if(usuarioActivo != null){
            usuarioActivo = null;
            return new ResponseEntity<String>("Usuario deslogueado", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("No existe un usuario logueado para desloguear", HttpStatus.CONFLICT);
    }
    
    public static User getUsuarioActivo(){return usuarioActivo;}

    public static void setUsuarioActivo(User usuarioNuevo){usuarioActivo = usuarioNuevo;}
    
}
