package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShirtPage extends PageObject {
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Classic Tee (Black)")
	WebElement blackTeeLink;

	public ShirtPage(WebDriver driver) {
		super(driver);
	}

	public BlackTeePage openBlackTee() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", blackTeeLink);
		//blackTeeLink.click();
		return new BlackTeePage(this.driver);
	}

}
