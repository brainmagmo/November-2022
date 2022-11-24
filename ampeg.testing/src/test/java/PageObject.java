import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObject {

	protected WebDriver driver;
	protected String URL;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return URL;
	}
	
	protected WebElement find(By by) {
		  return this.driver.findElement(by);
	}

}