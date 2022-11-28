
public class DriverManagerFactory {
	
	public static DriverManager getManager(String name) {
		
		DriverManager manager = null;
		
		switch (name.toLowerCase()) {
		case "chrome":
			manager = new ChromeDriverManager();
			break;
		case "edge":
			manager = new EdgeDriverManager();			
			break;
		default:
			//throw error?
			System.out.println(name + " driver manager not found.");
		}
		
		return manager;
	}
	
}
