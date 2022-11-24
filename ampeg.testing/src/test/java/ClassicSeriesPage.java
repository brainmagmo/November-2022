import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassicSeriesPage extends PageObject {

	public ClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT410HLFPage openSVT410HLF() {
		find(By.linkText("SVT-410HLF"))
			.click();
		return new SVT410HLFPage(this.driver);
	}

}
