package com.example.uade.tpoDatos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Data
@Document(collection = "Usuarios")
public class User {
    
    @Id
    private Long id;

    private String nombre;
    private String email;
    private String dni;
    private String tipo;

    public User(){

    }
    public User(Long id, String nombre, String email, String dni){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.tipo = "LOW";
    }

}
