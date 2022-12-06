import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShopPage extends PageObject {
	
	@FindBy(how=How.CSS, using="a#ui-id-5")
	WebElement merch;
	@FindBy(how=How.CSS, using="a#ui-id-15")
	WebElement shirts;

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public ShirtPage openShirts() {
		Actions mouse = new Actions(this.driver);
		mouse.moveToElement(merch)
		.perform();
		shirts.click();
		return new ShirtPage(this.driver);
	}

}
