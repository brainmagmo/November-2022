import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeritageSeriesPage extends PageObject {

	public HeritageSeriesPage(WebDriver driver) {
		super(driver);
	}

	public Heritage50thAnniversarySVTPage openFirstLearnMore() {
		find(By.cssSelector("#first-prod div.title a"))
		.click();
		return new Heritage50thAnniversarySVTPage(this.driver);
	}

}
