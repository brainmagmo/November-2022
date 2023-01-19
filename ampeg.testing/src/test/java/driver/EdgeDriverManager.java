package driver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var edgeDpath = "C:\\Users\\trevo\\webdrivers\\edgeedriver.exe";
		System.setProperty("webdriver.chrome.driver", edgeDpath);

		setDriver(new EdgeDriver());
	}

}
