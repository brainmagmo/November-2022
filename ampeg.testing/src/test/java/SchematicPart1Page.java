import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SchematicPart1Page extends PageObject {
	
	@FindBy(how=How.TAG_NAME , using="p")
	WebElement paragraph;

	public SchematicPart1Page(WebDriver driver) {
		super(driver);
	}

	public String getRegularText() {
		var text = paragraph.getText();
		return text;
	}

}
