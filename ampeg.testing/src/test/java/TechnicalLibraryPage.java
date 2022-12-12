import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechnicalLibraryPage extends PageObject {
	
	@FindBy(how=How.LINK_TEXT , using="Schematics/")
	WebElement schematicsLink;

	public TechnicalLibraryPage(WebDriver driver) {
		super(driver);
	}

	public SchematicsPage openSchematics() {
		schematicsLink.click();
		return new SchematicsPage(this.driver);
	}

}
