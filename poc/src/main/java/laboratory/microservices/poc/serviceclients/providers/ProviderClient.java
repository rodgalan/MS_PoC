package laboratory.microservices.poc.serviceclients.providers;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import laboratory.microservices.poc.providers.ProviderBean;


/*
 * Exemples de codi, no l'estic utilizant desde enlloc!
 */
@Deprecated
public class ProviderClient {
	
	public static void main( String[] args )
    {
		SpringApplication.run(ProviderClient.class, args);
	}
	
	
	//SIN USAR RIBBON, SOLO DISCOVERY DIRECTAMENTE CONTRA EUREKA
	@Component
	class DiscoveryProvider implements CommandLineRunner {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @Override
	    public void run(String... strings) throws Exception {
	        discoveryClient.getInstances("providers-service").forEach((ServiceInstance s) -> {
	            System.out.println(ToStringBuilder.reflectionToString(s));
	        });
	    }
	}
	
	//USANDO RIBBON (Netflix has a Eureka-aware client-side load-balancing client called Ribbon that Spring Cloud integrates extensively)
	@Component
	class RestTemplateExample implements CommandLineRunner {

	    @Autowired
	    private RestTemplate restTemplate;

	    @Override
	    public void run(String... strings) throws Exception {
	        // use the "smart" Eureka-aware RestTemplate
	        ResponseEntity<List<ProviderBean>> exchange =
	                this.restTemplate.exchange(
	                        "http://providers-service/{providerId}",
	                        HttpMethod.GET,
	                        null,  //Rquest Entity
	                        new ParameterizedTypeReference<List<ProviderBean>>() {
	                        },
	                        (Object) "mstine");

	        exchange.getBody().forEach(System.out::println);
	    }
	}
	
	//USANDO FEIGN (Feign is a handy project from Netflix that lets you describe a REST API client declaratively with annotations on an interface)
	@Component
	class FeignExample implements CommandLineRunner {

	    @Autowired
	    private ProvidersClient providersClient;

	    @Override
	    public void run(String... strings) throws Exception {
	        this.providersClient.getProvider("jlong").forEach(System.out::println);
	    }
	}
	
	@FeignClient("providers-service")
	interface ProvidersClient {
	    @RequestMapping(method = RequestMethod.GET, value = "/{providerId}")
	    List<ProviderBean> getProvider(@PathVariable("providerId") String providerId);
	}

}
