package laboratory.microservices.poc.providerswithusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import laboratory.microservices.poc.providers.ProviderBean;
import laboratory.microservices.poc.users.UserBean;

@RestController
@RequestMapping("/providersWithUsers")
public class ProvidersWithUsersService {
	
	@Autowired
	private ProvidersClient providersClient;
	
	@Autowired
	private UsersClient usersClient;
		
	@RequestMapping(value="/{providerId}", method = RequestMethod.GET)
	public ProviderWithUsersBean getProviderWithUsers(@PathVariable String providerId){
		//Crida a providers-service i users-service (amb el mateix id, nomes estem jugant)
		
		//UserBean user=usersClient.getClient(providerId);
		UserBean user=this.getUser(providerId);
		
		//ProviderBean provider=providersClient.getProvider(providerId);
		ProviderBean provider=this.getProvider(providerId);
		
		ProviderWithUsersBean result=new ProviderWithUsersBean(provider,user);
		return result;
	}
	
	@HystrixCommand(fallbackMethod = "getDefaultUser")
	public UserBean getUser(String userId){
		return usersClient.getClient(userId);
	}
	
	public UserBean getDefaultUser(String userId){
		return new UserBean();
	}
	
	@HystrixCommand(fallbackMethod = "getDefaultProvider")
	public ProviderBean getProvider(String providerId){
		return providersClient.getProvider(providerId);
	}
	
	public ProviderBean getDefaultProvider(String providerId){
		return new ProviderBean();
	}
	
	@FeignClient("providers-service")
	//@FeignClient(url="http://localhost:61310/providers")
	interface ProvidersClient { 
		@RequestMapping(value="/providers/{providerId}", method = RequestMethod.GET)
	    ProviderBean getProvider(@PathVariable("providerId") String providerId);
	}
	
	@FeignClient("users-service")
	//@FeignClient(url="http://localhost:61320/users")
	interface UsersClient { 
		@RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
	    UserBean getClient(@PathVariable("userId") String userId);
	} 
}
