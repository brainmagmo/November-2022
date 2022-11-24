import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchematicPart1Page extends PageObject {

	public SchematicPart1Page(WebDriver driver) {
		super(driver);
	}

	public String getRegularText() {
		return find(By.tagName("p"))
				.getText()
				;
	}

}
