package foundation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected WebDriver driver;
	private PageRepository pageRepository;
	
	@BeforeMethod
	public void setup() {
		var browserType = "chrome";
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.supressWarnings();
		this.manager.createDriver();
		this.manager.setImplicitWait(10);
		this.driver = manager.getDriver();
		this.manager.maximizeWindow();
		this.pageRepository = new PageRepository(this.driver);
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
	
	  protected PageRepository fromPages() {
			return this.pageRepository;
		}
}