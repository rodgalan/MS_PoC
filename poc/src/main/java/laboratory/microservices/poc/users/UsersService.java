package laboratory.microservices.poc.users;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UsersService {
	
	@RequestMapping(value="{userId}", method = RequestMethod.GET)
	public UserBean getUser(@PathVariable("userId") String userId){
		//TODO: Control parseInt error
		return new UserBean(Integer.parseInt(userId),"Anna","Rodriguez");
	}
	
}
