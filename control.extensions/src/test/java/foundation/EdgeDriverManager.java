package foundation;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	public String findOS() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	@Override
	public void createDriver() {
		String osType = findOS();
		
		if(osType.equals("Windows 10") || osType.equals("Windows 11")) {
			var driverPath = "C:\\temp\\msedgedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
		} 
		
		if(osType.equals("Mac OS X")) {
			var driverPath = "/Users/temp/msedgedriver";
			System.setProperty("webdriver.chrome.driver", driverPath);
		}
		
		this.setDriver(new EdgeDriver());
	}
}