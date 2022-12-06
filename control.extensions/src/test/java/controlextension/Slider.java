package controlextension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Slider extends ControlExtensionBase {
	
	public Slider(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public void setValue(int value) {
		var slide = this.mappedElement.findElement(By.tagName("input"));
		var currentValue = Integer.parseInt(getValue());
		int difference = value - currentValue;
		for(int i = 0; i < difference; i++) {
			slide.sendKeys(Keys.ARROW_RIGHT);
		}
		for(int i = 0; i > difference; i--) {
			slide.sendKeys(Keys.ARROW_LEFT);
		}
	}
	
	public void setValue(String value) {
		this.setValue(Integer.parseInt(value));
	}

	public String getValue() {
		var value = this.mappedElement.findElement(By.id("sliderValue"));
		return value.getAttribute("value");
	}
}
