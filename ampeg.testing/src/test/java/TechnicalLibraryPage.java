import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TechnicalLibraryPage extends PageObject {

	public TechnicalLibraryPage(WebDriver driver) {
		super(driver);
	}

	public SchematicsPage openSchematics() {
		find(By.linkText("Schematics/"))
		.click();
		return new SchematicsPage(this.driver);
	}

}
