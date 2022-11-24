import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	protected String URL = "https://ampeg.com/";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ProductPage openProductPage() {
		find(By.cssSelector("a[title='Products']"))
			.click();
		
		return new ProductPage(this.driver);
	}
	
	public String getURL() {
		return URL;
	}

}
