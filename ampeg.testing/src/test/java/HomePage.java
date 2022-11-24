import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ProductPage openProductPage() {
		find(By.cssSelector("a[title='Products']"))
			.click();
		
		return new ProductPage(this.driver);
	}

	public ShopPage openShop() {
		find(By.linkText("SHOP NOW"))  
		.click()
		;
		return new ShopPage(this.driver);
	}

	public TechnicalLibraryPage openTechnicalLibrary() {
		find(By.linkText("Technical Library"))
		.click()
		;
		return new TechnicalLibraryPage(this.driver);
	}
}
