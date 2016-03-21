package laboratory.microservices.poc.providers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("laboratory.microservices.poc.providers")

@EnableEurekaClient
//@EnableDiscoveryClient
public class ProvidersServer 
{
    public static void main( String[] args )
    {
    	System.setProperty("spring.config.name", "providers-server");
		SpringApplication.run(ProvidersServer.class, args);
	}
}
