package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ClassicSeriesPage extends PageObject {
		
	@FindBy(how=How.LINK_TEXT , using="SVT-410HLF")
	WebElement productLink;

	public ClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT410HLFPage openSVT410HLF() {
		productLink.click();
		return new SVT410HLFPage(this.driver);
	}

}
