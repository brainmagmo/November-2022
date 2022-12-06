package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import controlextension.RadioGroup;

public class RadioPage extends PageObjectBase {
	
	@FindBy(xpath="//input[@type='radio']/../..")
	private WebElement radioGroup;

	public RadioPage(WebDriver driver) {
		super(driver);
		driver.get("https://demoqa.com/radio-button");
	}

	public RadioGroup getRadioGroup() {
		return new RadioGroup(radioGroup);
	}

}
