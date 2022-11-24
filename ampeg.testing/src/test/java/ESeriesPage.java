import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ESeriesPage extends PageObject {

	public ESeriesPage(WebDriver driver) {
		super(driver);
	}

	public EchoTwinPage openEchoTwin() {
		find(By.linkText("ET-1B (Echo Twin)/"))
		.click()
		;
		return new EchoTwinPage(this.driver);
	}

}
