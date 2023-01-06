package com.jlpcb.getXinYedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jlpcb.getXinYedemo.mapper")
public class GetXinYedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetXinYedemoApplication.class, args);
	}

}
