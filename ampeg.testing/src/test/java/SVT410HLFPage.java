import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SVT410HLFPage extends PageObject {
	
	@FindBy(how=How.CSS , using="#artist b")
	WebElement artistName;

	public SVT410HLFPage(WebDriver driver) {
		super(driver);
	}

	public String getArtist() {
		String text = artistName.getText();
		return text;
	}

}
