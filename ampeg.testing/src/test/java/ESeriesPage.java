import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ESeriesPage extends PageObject {
	
	@FindBy(how=How.LINK_TEXT , using="ET-1B (Echo Twin)/")
	WebElement echoTwinLink;

	public ESeriesPage(WebDriver driver) {
		super(driver);
	}

	public EchoTwinPage openEchoTwin() {
		echoTwinLink.click();
		return new EchoTwinPage(this.driver);
	}

}
