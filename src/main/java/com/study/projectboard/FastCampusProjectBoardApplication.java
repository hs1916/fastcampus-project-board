package com.study.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampusProjectBoardApplication {

	// 실제 주석 추가 변경점 잡기 위함

	public static void main(String[] args) {
		SpringApplication.run(FastCampusProjectBoardApplication.class, args);
	}

}
