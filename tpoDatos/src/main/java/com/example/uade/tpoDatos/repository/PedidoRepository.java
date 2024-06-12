package com.example.uade.tpoDatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.uade.tpoDatos.entity.Pedido;


@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Long>{

}