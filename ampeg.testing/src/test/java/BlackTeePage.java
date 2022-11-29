import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BlackTeePage extends PageObject {

	public BlackTeePage(WebDriver driver) {
		super(driver);
	}

	public BlackTeePage addXLtoCart() {
		new Select(find(By.cssSelector("select#attribute178")))
		.selectByVisibleText("XL");
		find(By.cssSelector("button#product-addtocart-button"))
		.click();

		return this;
	}

	public String getCartCount() {
		return find(By.cssSelector("span.counter-number"))
				.getText();
	}
	
	public WebElement ableToAddXLtoCart() {
		new Select(find(By.cssSelector("select#attribute178")))
		.selectByVisibleText("XL");
		find(By.cssSelector("button#product-addtocart-button"))
		.click();
		
		var wait = new WebDriverWait(this.driver, 10);
		By saysOne = By.xpath("//div[@class='minicart-wrapper']//span[@class='counter-number' and text()='1']");
		var b = wait.until(ExpectedConditions.presenceOfElementLocated(saysOne));
		
		return b;
	}

}
