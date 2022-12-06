package controlextension;
import org.openqa.selenium.WebElement;

public class ControlExtensionBase {

	protected WebElement mappedElement;

	public ControlExtensionBase(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void click() {
		this.mappedElement.click();
	}
}
