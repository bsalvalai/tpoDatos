package com.example.uade.tpoDatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;


@SpringBootApplication
public class TpoDatosApplication {

	public static void main(String[] args) {

		SpringApplication.run(TpoDatosApplication.class, args);
	}



}
