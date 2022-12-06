import org.openqa.selenium.WebElement;

public class Hyperlink extends ControlExtensionBase {
	
	WebElement mappedElement;

	public Hyperlink(WebElement link) {
		this.mappedElement = link;
	}

	public void click() {
		mappedElement.click();
	}
}
