package com.yogiyo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = {"com.yogiyo.**.dao"})
@SpringBootApplication
public class YogiyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogiyoApplication.class, args);
	}

}
