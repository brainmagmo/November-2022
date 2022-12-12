import com.opencsv.bean.CsvBindByName;

public class Bass {
	@CsvBindByName(column = "Make")
	private String make;
	@CsvBindByName(column = "Model")
	private String model;
		
	public Bass() {
	}
	
	public Bass(String model, String make) {
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
	
	@Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
        
        if (!(o instanceof Bass)) {
            return false;
        }
         
        Bass c = (Bass) o;
         
        return c.make.equals(this.make)
                && c.model.equals(this.model);
    }
	
	@Override
    public String toString() {
        return "make: " + this.make + ", model: " + this.model;
    }
}