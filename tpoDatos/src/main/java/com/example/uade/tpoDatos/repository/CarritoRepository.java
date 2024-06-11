package com.example.uade.tpoDatos.repository;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.uade.tpoDatos.entity.Carrito;
import com.example.uade.tpoDatos.entity.Producto;

@Repository
public class CarritoRepository {
    
    private static final String HASH_KEY = "carrito";
    private RedisTemplate template;

    public Carrito save(Carrito carrito){
        template.opsForHash().put(HASH_KEY, carrito.getId(), carrito);
        return carrito;
    }

    public List<Carrito> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Carrito findById(int id){
        return (Carrito) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "Se borro con exito";
    }
}
