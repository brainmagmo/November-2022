import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EchoTwinPage extends PageObject {

	public EchoTwinPage(WebDriver driver) {
		super(driver);
	}

	public SchematicPart1Page openSchematicPart1() {
		find(By.linkText("Echo Twin Schematic Part 1.gif"))
		.click()
		;
		return new SchematicPart1Page(this.driver);
	}

}
