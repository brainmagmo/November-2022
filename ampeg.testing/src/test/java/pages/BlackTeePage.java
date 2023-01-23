package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.*;

public class BlackTeePage extends PageObject {
	
	@FindBy(how=How.CSS, using="span.cart-quantity.countPill--positive")
	WebElement CartCountPositive;
	@FindBy(how=How.CSS, using="select#attribute_select_123")
	WebElement sizeDropdown;
	@FindBy(how=How.CSS, using="input#form-action-addToCart")
	WebElement addToCartButton;

	public BlackTeePage(WebDriver driver) {
		super(driver);
	}

	public String getCartCount() {
		//this.driver.findElement(By.partialLinkText("Continue Shoppin"));
		//String count = CartCountPositive.getText();
		//System.out.println(count);
		String count = this.driver.findElement(By.xpath("//p[@data-cart-quantity]")).getAttribute("data-cart-quantity");
		return count;
	}
	
	public BlackTeePage ableToAddXLtoCart() {
		new Select(sizeDropdown)
		.selectByVisibleText("XL");
		addToCartButton.click();
		
		var wait = new WebDriverWait(this.driver, 10);
		By saysOne = By.xpath("//span[contains(@class,'countPill cart-quantity countPill--positive')"
				+ " and text()='1']");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(saysOne));
		
		return this;
	}

}
