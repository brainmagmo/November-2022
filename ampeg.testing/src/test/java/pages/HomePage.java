package pages;
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
	@FindBy(how=How.CSS , using="a.artists")
	WebElement artistsLink;
	@FindBy(how=How.CSS , using="a.shop")
	WebElement shoppingCartLink;
	
	
	private String homePageURL;

	public HomePage(WebDriver driver) {
		super(driver);
		homePageURL = "https://www.ampeg.com";	
	}

	public HomePage navigate() {
		this.driver.navigate()
		.to(homePageURL);
		return null;
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
	
	public ArtistsPage openArtists() {
		artistsLink.click();
		return new ArtistsPage(this.driver);
	}

	public ShoppingCartPage openShoppingCart() {
		shoppingCartLink.click();
		return new ShoppingCartPage(this.driver);
	}
}
