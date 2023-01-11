package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.*;

public class BlackTeePage extends PageObject {
	
	@FindBy(how=How.CSS, using="span.counter-number")
	WebElement CartCount;
	@FindBy(how=How.CSS, using="select#attribute178")
	WebElement sizeDropdown;
	@FindBy(how=How.CSS, using="#product-addtocart-button")
	WebElement addToCartButton;

	public BlackTeePage(WebDriver driver) {
		super(driver);
	}

	public String getCartCount() {
		String count = CartCount.getText();		
		return count;
	}
	
	public BlackTeePage ableToAddXLtoCart() {
		new Select(sizeDropdown)
		.selectByVisibleText("XL");
		addToCartButton.click();
		
		var wait = new WebDriverWait(this.driver, 10);
		By saysOne = By.xpath(""
				+ "//div[@class='minicart-wrapper']"
				+ "//span[@class='counter-number' "
				+ "and text()='1']");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(saysOne));
		
		return this;
	}

}
