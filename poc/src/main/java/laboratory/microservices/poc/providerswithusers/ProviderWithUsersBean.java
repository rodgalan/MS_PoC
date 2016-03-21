package laboratory.microservices.poc.providerswithusers;

import laboratory.microservices.poc.providers.ProviderBean;
import laboratory.microservices.poc.users.UserBean;

public class ProviderWithUsersBean {
	//Usaremos ProviderBean y UserBean en modo test(en entorno real cada MS estaria en su propio proyecto y seria independeinte, gestionado por equipos independeintes y autonomos)
	private ProviderBean provider;
	private UserBean user;
	
	
	
	public ProviderWithUsersBean(ProviderBean provider, UserBean user) {
		super();
		this.provider = provider;
		this.user = user;
	}
	public ProviderWithUsersBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProviderBean getProvider() {
		return provider;
	}
	public void setProvider(ProviderBean provider) {
		this.provider = provider;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
	
}
