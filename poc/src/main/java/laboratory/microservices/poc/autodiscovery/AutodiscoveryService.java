package laboratory.microservices.poc.autodiscovery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autodiscovery")
@EnableDiscoveryClient
public class AutodiscoveryService {
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLocalServiceInfo(){
		ServiceInstance localInstance = client.getLocalServiceInstance(); 
		return "Auto Discovery Info: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort(); 
	}
	
	@RequestMapping(value="/{serviceName}", method = RequestMethod.GET)
	public String getServiceInfo(@PathVariable String serviceName){
		String result="";
		List<ServiceInstance> instances=client.getInstances(serviceName);
		for(int i=0; i<instances.size(); i++){
			result=result+"INSTANCE --> HOST: "+instances.get(i).getHost()+", PORT: "+instances.get(i).getPort()+", SERVICE_ID: "+instances.get(i).getServiceId()+", URI: "+instances.get(i).getUri()+"\n";
		}
		return result; 
	}

}
