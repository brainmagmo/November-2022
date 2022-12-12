package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import controlextension.RadioGroup;

public class RadioPage extends PageObjectBase {
	
	@FindBy(xpath="//input[@type='radio']/../..")
	private WebElement radioElement;
	private RadioGroup radioGroup;
	

	public RadioPage(WebDriver driver) {
		super(driver);
		driver.get("https://demoqa.com/radio-button");
		this.radioGroup = null;
	}

	public RadioGroup getRadioGroup() {
		if(this.radioGroup == null)
			this.radioGroup = new RadioGroup(radioElement);
		return this.radioGroup;
	}

	public RadioPage selectRadioButtonValue(String buttonValue) {
		getRadioGroup()
		.getButton(buttonValue)
		.select();
		return this;
	}

	public String getSelectedValue() {
		return getRadioGroup()
		.getSelected()
		.getText();
	}

}
