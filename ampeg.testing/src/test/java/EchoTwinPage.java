import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EchoTwinPage extends PageObject {
	
	@FindBy(how=How.LINK_TEXT , using="Echo Twin Schematic Part 1.gif")
	WebElement schematicsLink;

	public EchoTwinPage(WebDriver driver) {
		super(driver);
	}

	public SchematicPart1Page openSchematicPart1() {
		schematicsLink.click();
		return new SchematicPart1Page(this.driver);
	}

}
