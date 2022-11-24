import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {

	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return this.driver.getCurrentUrl();
	}
	
	protected WebElement find(By by) {
		  return this.driver.findElement(by);
	}

}