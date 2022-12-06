package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void quitDriver() {
		this.driver.quit();
	}
	
	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	protected DriverManager maximizeWindow() {
		this.driver.manage().window().maximize();
		return this;
	}

	protected DriverManager setImplicitWait(int i) {
		this.driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		return this;
	};	
}