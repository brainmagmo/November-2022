package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected PageRepository pageRepository;
	private WebDriver driver;
	//protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		var browserType = "chrome";
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = manager.getDriver();
		var manage = this.driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.pageRepository = new PageRepository(this.driver);
		
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
	
	public PageRepository visit() {
		return this.pageRepository;
	}
}
