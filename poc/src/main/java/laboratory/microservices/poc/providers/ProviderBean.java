package laboratory.microservices.poc.providers;

public class ProviderBean {
	private int id;
	private String providerName;
	
	
	
	public ProviderBean(int id, String providerName) {
		super();
		this.id = id;
		this.providerName = providerName;
	}
	public ProviderBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	
	
	
	

}
