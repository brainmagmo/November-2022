import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		InitPageFactory();
	}

	private void InitPageFactory() {
		PageFactory.initElements(this.driver, this);
	}

	public String getURL() {
		return this.driver.getCurrentUrl();
	}

}