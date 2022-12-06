import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioPage extends PageObjectBase {
	
	@FindBy(xpath="//input[@type='radio']/../..")
	WebElement radioGroup;

	public RadioPage(WebDriver driver) {
		super(driver);
		driver.get("https://demoqa.com/radio-button");
	}

	public RadioGroup getRadioGroup() {
		return new RadioGroup(radioGroup);
	}

}
