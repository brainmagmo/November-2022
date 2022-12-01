import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SchematicsPage extends PageObject {
	
	@FindBy(how=How.LINK_TEXT , using="E Series/")
	WebElement eSeriesLink;

	public SchematicsPage(WebDriver driver) {
		super(driver);
	}

	public ESeriesPage openESeries() {
		eSeriesLink.click();
		return new ESeriesPage(this.driver);
	}

}
