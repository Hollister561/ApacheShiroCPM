package com.zhyu.cpmshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhyu.cpmshiro.mapper"})
public class CpmshiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpmshiroApplication.class, args);
	}

}
