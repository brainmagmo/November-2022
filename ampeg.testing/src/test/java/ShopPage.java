import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShopPage extends PageObject {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public ShirtPage openShirts() {
		Actions mouse = new Actions(this.driver);
		WebElement merch = find(By.cssSelector("a#ui-id-5"));
		mouse.moveToElement(merch).perform();
		find(By.cssSelector("a#ui-id-15"))
		.click()
		;
		return new ShirtPage(this.driver);
	}

}
