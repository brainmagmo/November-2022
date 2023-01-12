package pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	@FindBy(how=How.TAG_NAME, using="title")
	WebElement title;
	
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