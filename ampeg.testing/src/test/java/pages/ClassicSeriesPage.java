package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ClassicSeriesPage extends PageObject {
		
	@FindBy(how=How.XPATH , using="//h2[contains(text(),'410HLF')]/../a")
	WebElement productLink;

	public ClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT410HLFPage openSVT410HLF() {
		productLink.click();
		return new SVT410HLFPage(this.driver);
	}

}
