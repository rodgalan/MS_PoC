package laboratory.microservices.poc.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import laboratory.microservices.poc.serviceregistration.ServiceRegistrationServer;

@SpringBootApplication
//@EnableTurbineAmqp --> Needs RabbitMQ
@EnableHystrixDashboard
@EnableDiscoveryClient
public class RealTimeMonitoringServer {

	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "monitoring-server");
		SpringApplication.run(ServiceRegistrationServer.class, args);
	}

}
