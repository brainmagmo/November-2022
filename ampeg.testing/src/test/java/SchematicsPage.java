import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchematicsPage extends PageObject {

	public SchematicsPage(WebDriver driver) {
		super(driver);
	}

	public ESeriesPage openESeries() {
		find(By.linkText("E Series/"))
		.click();
		return new ESeriesPage(this.driver);
	}

}
