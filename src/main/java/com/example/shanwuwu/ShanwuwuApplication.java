package com.example.shanwuwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shanwuwu.mapper")
public class ShanwuwuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShanwuwuApplication.class, args);
	}

}
