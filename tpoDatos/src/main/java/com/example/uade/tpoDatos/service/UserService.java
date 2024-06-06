package com.example.uade.tpoDatos.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.uade.tpoDatos.entity.Login;
import com.example.uade.tpoDatos.entity.User;
import com.example.uade.tpoDatos.repository.UserRepository;
import com.example.uade.tpoDatos.service.interfaces.UserServiceImpl;



@Service
public class UserService implements UserServiceImpl{ 
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> crearUsuario(User user) {
        if (userRepository.findByNombre(user.getNombre())!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userError");
        } else if (userRepository.findByEmail(user.getEmail())!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mailError");
        }else {
            try {

                userRepository.save(user);


                return ResponseEntity.ok("ok");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
            }
        }
    }

    @Override
    public ResponseEntity<String> loguearUsuario(Login login) {
        List<User> users = userRepository.findAll();
        for(User user : users){
            if (user.getNombre().equals(login.getNombre()) && user.getDni().equals(login.getDni())){
                System.out.println("TODO BIEN");
                return ResponseEntity.ok("Usuario autenticado correctamente");
            }
        }
        //System.out.println("TODO MAL");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }

}
