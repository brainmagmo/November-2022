package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class CucumberTestBase {
	protected DriverManager manager;
	protected PageRepository pageRepository;
	private WebDriver driver;

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

	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
	
	public PageRepository fromPages() {
		return this.pageRepository;
	}
}
