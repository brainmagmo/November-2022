import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton extends ControlExtensionBase {
	
	private WebElement mappedElement;
	
	private static String labelXPath="./../label";

	public RadioButton(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public void select() {
		getLabelElement().click();
	}
	
	public String getText() {
		return getLabelElement().getText();
	}
	
	private WebElement getLabelElement() {
		return this.mappedElement.findElement(By.xpath(labelXPath));
	}
}
