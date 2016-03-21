package laboratory.microservices.poc.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("laboratory.microservices.poc.users")

@EnableEurekaClient
//@EnableDiscoveryClient
public class UsersServer 
{
    public static void main( String[] args )
    {
    	System.setProperty("spring.config.name", "users-server");
    	SpringApplication.run(UsersServer.class, args);
    }
}
