import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SVT410HLFPage extends PageObject {

	public SVT410HLFPage(WebDriver driver) {
		super(driver);
	}

	public String getArtist() {
		String text = find(By.cssSelector("#artist b")).getText();
		return text;
	}

}
