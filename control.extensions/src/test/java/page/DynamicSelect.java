package page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;

import controlextension.ControlExtensionBase;

public class DynamicSelect extends ControlExtensionBase {
	
	@FindBy(xpath=".//div[contains(@class,'multiValue')]")
	private List<WebElement> values;

	public DynamicSelect(WebElement mappedElement) {
		super(mappedElement);
	}

	public DynamicSelect select(String value) {
		new Actions(((WrapsDriver)this.mappedElement).getWrappedDriver())
		.moveToElement(this.mappedElement)
		.perform();
		this.mappedElement.click();
		this.mappedElement.sendKeys(value);
		this.mappedElement.sendKeys(Keys.ENTER);
		return this;
	}
	
	public String[] getSelected() {
		return values.stream()
		.map(WebElement::getText)
		.toArray(String[]::new);
	}
}
