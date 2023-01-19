package driver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var chromeDpath = "C:\\Users\\trevo\\webdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDpath);

		setDriver(new ChromeDriver());
	}

}
