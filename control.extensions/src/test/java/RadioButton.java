import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton extends ControlExtensionBase {
	
	private WebElement buttonElement;
	
	private static String labelXPath="./../label";


	public RadioButton(WebElement buttonElement) {
		this.buttonElement = buttonElement;
	}

	public void select() {
		getLabelElement().click();
	}
	
	public String getText() {
		return getLabelElement().getText();
	}
	
	private WebElement getLabelElement() {
		return this.buttonElement.findElement(By.xpath(labelXPath));
	}

}
