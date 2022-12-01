import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Heritage50thAnniversarySVTPage extends PageObject {
	
	@FindBy(how=How.LINK_TEXT , using="MANUALS")
	WebElement manualsLink;

	public Heritage50thAnniversarySVTPage(WebDriver driver) {
		super(driver);
	}

	public HeritageManualsPage openManuals() {
		manualsLink.click();

		return new HeritageManualsPage(this.driver);
	}

}
