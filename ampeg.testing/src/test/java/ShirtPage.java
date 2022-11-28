import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShirtPage extends PageObject {

	public ShirtPage(WebDriver driver) {
		super(driver);
	}

	public BlackTeePage openBlackTee() {
		find(By.cssSelector("img[alt='Classic Tee (Black)']"))
		.click();
		return new BlackTeePage(this.driver);
	}

}
