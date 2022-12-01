import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageObject {
	
	@FindBy(how=How.CSS , using="a[title='Products']")
	WebElement productsLink;
	@FindBy(how=How.LINK_TEXT , using="SHOP NOW")
	WebElement shopNowLink;
	@FindBy(how=How.LINK_TEXT , using="Technical Library")
	WebElement technicalLibraryLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ProductPage openProductPage() {
		productsLink.click();
		
		return new ProductPage(this.driver);
	}

	public ShopPage openShop() {
		shopNowLink.click();
		return new ShopPage(this.driver);
	}

	public TechnicalLibraryPage openTechnicalLibrary() {
		technicalLibraryLink.click();
		return new TechnicalLibraryPage(this.driver);
	}
}
