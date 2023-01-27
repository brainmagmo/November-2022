import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AmpegTest {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		  launchDriver("https://www.ampeg.com");
	  }

	@AfterMethod
	public void afterMethod() {
		  closeDriver();
	  }

	private void launchDriver(String url) {
		var chromeDpath = "C:\\temp\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDpath);

		this.driver = new ChromeDriver();

		this.driver.manage()
			.timeouts()
			.implicitlyWait(3, TimeUnit.SECONDS);
		
		this.driver.navigate()
			.to(url); 
	}

	private void closeDriver() {
		  if(this.driver != null) {
			  this.driver.close();
		  }
	  }

	protected WebElement find(By by) {
		  return this.driver.findElement(by);
	  }

}