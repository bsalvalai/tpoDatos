package com.example.uade.tpoDatos.controllers;


import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.uade.tpoDatos.entity.Login;
import com.example.uade.tpoDatos.entity.User;
import com.example.uade.tpoDatos.repository.UserRepository;
import com.example.uade.tpoDatos.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {

    private static User usuarioActivo;
    private static LocalDateTime horaLogueo;
    private static LocalDateTime horaDeslogueo;

    @Autowired
    private UserService userService; 

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/create")
    public ResponseEntity<String> crearUsuario(@RequestBody User user) {
        return userService.crearUsuario(user);
    }
    
    @GetMapping("/login")
    public ResponseEntity<String> loguearUsuario(@RequestBody Login login) {
        if(usuarioActivo != null){
            return new ResponseEntity<>("Ya hay un usuario logueado", HttpStatus.CONFLICT);
        }
        horaLogueo = LocalDateTime.now();
        return userService.loguearUsuario(login);
    }

    @GetMapping("/desloguear")
    public ResponseEntity<String> desloguearUsuario() {
        if(usuarioActivo != null){
            horaDeslogueo = LocalDateTime.now();
            Duration duracion = Duration.between(horaLogueo, horaDeslogueo);
            if(duracion.getSeconds() < 120){
                usuarioActivo.setTipo("LOW");
                userRepository.save(usuarioActivo);
            } else if(duracion.getSeconds() < 240){
                usuarioActivo.setTipo("MEDIUM");
                userRepository.save(usuarioActivo);
            } else{
                usuarioActivo.setTipo("TOP");
                userRepository.save(usuarioActivo);
            }
            usuarioActivo = null;
            return new ResponseEntity<String>("Usuario deslogueado", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("No existe un usuario logueado para desloguear", HttpStatus.CONFLICT);
    }
    
    public static User getUsuarioActivo(){return usuarioActivo;}

    public static void setUsuarioActivo(User usuarioNuevo){usuarioActivo = usuarioNuevo;}
    
}
