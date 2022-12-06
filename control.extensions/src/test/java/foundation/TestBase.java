package foundation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		var browserType = "chrome";
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.manager.setImplicitWait(10);
		this.driver = manager.getDriver();
		this.manager.maximizeWindow();
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
}