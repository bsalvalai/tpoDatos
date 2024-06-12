package com.example.uade.tpoDatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.uade.tpoDatos.entity.Pedido;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Long>{

}