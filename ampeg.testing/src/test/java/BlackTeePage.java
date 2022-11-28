import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BlackTeePage extends PageObject {

	public BlackTeePage(WebDriver driver) {
		super(driver);
	}

	public BlackTeePage addXLtoCart() {
		new Select(find(By.cssSelector("select#attribute178")))
		.selectByVisibleText("XL");
		find(By.cssSelector("button#product-addtocart-button"))
		.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this;
	}

	public String getCartCount() {
		return find(By.cssSelector("span.counter-number"))
				.getText();
	}

}
