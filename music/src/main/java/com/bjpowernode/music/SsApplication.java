package com.bjpowernode.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 林李权、吴先锋
 *
 */
@SpringBootApplication
@MapperScan("com.bjpowernode.music.*.mapper")
public class SsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsApplication.class, args);
	}
}
