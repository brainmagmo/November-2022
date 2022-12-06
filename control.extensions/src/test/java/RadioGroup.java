import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioGroup extends ControlExtensionBase {
	
	private WebElement groupElement;

	public RadioGroup(WebElement radioGroupElement) {
		this.groupElement = radioGroupElement;
	}

	public RadioButton getButton(String label) {
		var buttonElement = groupElement.findElement(By.xpath("//*[text()='" +label+ "']/../input"));
		
		return new RadioButton(buttonElement);
	}

	public RadioButton getSelected() {
		var buttonElements = groupElement.findElements(By.tagName("input"));
		
		for(var buttonElement: buttonElements) {
			if(buttonElement.isSelected()) {
				return new RadioButton(buttonElement);
			}
		}
		
		return null;		
	}
}
