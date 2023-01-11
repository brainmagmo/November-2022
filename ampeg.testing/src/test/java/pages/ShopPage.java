package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShopPage extends PageObject {
	
	@FindBy(how=How.CSS, using="a[aria-label='Merch']")
	WebElement merch;
	@FindBy(how=How.CSS, using="a[aria-label='Shirts']")
	WebElement shirts;
	@FindBy(how=How.CSS, using=".mobileMenu-toggle")
	WebElement menu;
	
	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public ShirtPage openShirts() {
		Actions mouse = new Actions(this.driver);
		if(menu.isDisplayed()) {
			mouse.moveToElement(menu)
			.perform(); 
			menu.click();}
		mouse.moveToElement(merch)
		.perform();
		merch.click();
		shirts.click();
		return new ShirtPage(this.driver);
	}

}
