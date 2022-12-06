import org.openqa.selenium.WebElement;

public class Hyperlink extends ControlExtensionBase {
	
	private WebElement mappedElement;

	public Hyperlink(WebElement link) {
		this.mappedElement = link;
	}

	public void click() {
		this.mappedElement.click();
	}
}
