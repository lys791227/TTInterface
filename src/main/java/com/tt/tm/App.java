package com.tt.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 
 * @SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 * 
 * @SpringBootApplication 等待于：
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 * 
 *
 * 
 */
// @EnableConfigurationProperties({WiselySettings.class,Wisely2Settings.class})
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled","false");
		SpringApplication.run(App.class, args);
	}

}
