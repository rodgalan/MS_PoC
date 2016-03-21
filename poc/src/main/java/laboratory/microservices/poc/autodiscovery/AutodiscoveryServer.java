package laboratory.microservices.poc.autodiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("laboratory.microservices.poc.autodiscovery")
@EnableEurekaClient
public class AutodiscoveryServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "autodiscovery-server");
		SpringApplication.run(AutodiscoveryServer.class, args);
	}

}
