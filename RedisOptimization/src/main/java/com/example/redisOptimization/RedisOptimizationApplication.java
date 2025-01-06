package com.example.redisOptimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisOptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisOptimizationApplication.class, args);
	}

}
