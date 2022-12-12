import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShirtPage extends PageObject {
	
	@FindBy(how=How.CSS, using="img[alt='Classic Tee (Black)']")
	WebElement blackTeeLink;

	public ShirtPage(WebDriver driver) {
		super(driver);
	}

	public BlackTeePage openBlackTee() {
		blackTeeLink.click();
		return new BlackTeePage(this.driver);
	}

}
