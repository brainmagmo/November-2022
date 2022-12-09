
public class Bass {
	private String make;
	private String model;
		
	public Bass() {
	}
	
	public Bass(String make, String model) {
		this.model = model;
		this.make = make;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}  
}