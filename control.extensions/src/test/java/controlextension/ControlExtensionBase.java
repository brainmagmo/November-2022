package controlextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;

public class ControlExtensionBase {

	protected WebElement mappedElement;

	public ControlExtensionBase(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void click() {
		new Actions(getDriver())
		.moveToElement(this.mappedElement)
		.perform();
		this.mappedElement.click();
	}
	
	private WebDriver getDriver() {
		return ((WrapsDriver)this.mappedElement).getWrappedDriver();
	}
}
