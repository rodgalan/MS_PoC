package laboratory.microservices.poc.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
//@EnableZuulProxy
@EnableZuulServer
public class ProxyServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "proxy-server");
		SpringApplication.run(ProxyServer.class, args);
	}

}
