package com.example.shanwuwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"com.example.shanwuwu.mapper"})
@MapperScan(basePackages={"com.example.shanwuwu.mapper"})
public class ShanwuwuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShanwuwuApplication.class, args);
	}

}
