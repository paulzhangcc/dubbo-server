package com.paulzhangcc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.paulzhangcc.demo.dao.mysql.mapper") //注入mybatis配置文件
@ImportResource(locations={"classpath:spring/application*.xml"}) //映入spring配置
@EnableTransactionManagement
@EnableAsync
@ComponentScan("com.paulzhangcc")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
