import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Heritage50thAnniversarySVTPage extends PageObject {

	public Heritage50thAnniversarySVTPage(WebDriver driver) {
		super(driver);
	}

	public HeritageManualsPage openManuals() {
		find(By.linkText("MANUALS"))
		.click()
		;

		return new HeritageManualsPage(this.driver);
	}

}
