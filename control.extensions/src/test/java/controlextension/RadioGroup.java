package controlextension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioGroup extends ControlExtensionBase {

	public RadioGroup(WebElement mappedElement) {
		super(mappedElement);
	}

	public RadioButton getButton(String label) {
		var buttonElement = this.mappedElement.findElement(By.xpath(".//*[text()='" +label+ "']/../input"));
		
		return new RadioButton(buttonElement);
	}

	public RadioButton getSelected() {
		var buttonElements = this.mappedElement.findElements(By.tagName("input"));
		
		for(var buttonElement: buttonElements) {
			if(buttonElement.isSelected()) {
				return new RadioButton(buttonElement);
			}
		}
		
		return null;		
	}
}
