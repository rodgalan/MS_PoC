package laboratory.microservices.poc.providerswithusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("laboratory.microservices.poc.providerswithusers")
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProvidersWithUsersServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "providersUsers-server");
		SpringApplication.run(ProvidersWithUsersServer.class, args);
	}

}
