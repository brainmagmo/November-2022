package controlextension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton extends ControlExtensionBase {
	
	private WebElement label;
	private static String labelXPath="./../label";

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
		this.label = this.mappedElement.findElement(By.xpath(labelXPath));
	}

	public void select() {
		label.click();
	}
	
	public String getText() {
		return label.getText();
	}
}
