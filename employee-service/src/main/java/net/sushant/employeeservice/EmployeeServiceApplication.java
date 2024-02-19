package net.sushant.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Employee service rest apis",
		description = "Employee service rest apis Documentation",
		version = "v1.0",
		contact= @Contact( email= "sushantmhashakhetri3@gmail.com",name="sushantmhashakhetri"),
		license = @License(
			name = "MIT License",
			url = "http://www.opensource.org/licenses/mit-docs"
		)
	)
)
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class EmployeeServiceApplication {

	// @Bean
	// @LoadBalanced
	// public RestTemplate restTemplate(){
	// 	return new RestTemplate();
	// }

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
