package laboratory.microservices.poc.providers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/providers")
public class ProvidersService {
	
	@RequestMapping(value="/{providerId}", method = RequestMethod.GET)
	public ProviderBean getProvider(@PathVariable("providerId") String providerId){
		//TODO: Control parseInt error
		return new ProviderBean(Integer.parseInt(providerId),"Coca-Cola");
	}
	
}
