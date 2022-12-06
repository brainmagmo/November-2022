import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends ControlExtensionBase {
	
	private Select dropdown;

	public Dropdown(WebElement mappedElement) {
		this.dropdown = new Select(mappedElement);
	}

	public void setValue(String value) {
		this.dropdown.selectByVisibleText(value);
	}

	public String getValue() {
		var selected = this.dropdown.getFirstSelectedOption().getText();
		return selected;
	}

	public String[] getOptions() {
		var options = this.dropdown
				.getOptions()
				.stream()
				.map(WebElement::getText)
				.toArray(String[]::new);
		
		return options;
	}
}
