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
    private String password;
    private String dni;
    private String tipo = "LOW";

    public User(){

    }

}
