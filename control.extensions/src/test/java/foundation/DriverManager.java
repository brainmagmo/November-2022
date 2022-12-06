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
	
	protected abstract void supressWarnings();

	public DriverManager maximizeWindow() {
		this.driver.manage().window().maximize();
		return this;
	}

	public DriverManager setImplicitWait(int i) {
		this.driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		return this;
	};	
}