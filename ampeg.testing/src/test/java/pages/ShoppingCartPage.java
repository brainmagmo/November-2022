package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageObject {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public boolean userSeesCart() {
		boolean sawCart = this.driver
				.findElements(By
						.xpath("//h1[contains(text(),'Your Cart')]"))
				.size() > 0;
		return sawCart;
	}

}
