package controlextension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends ControlExtensionBase {
	
	protected Select select;
	
	public Dropdown(WebElement mappedElement) {
		super(mappedElement);
		this.select = new Select(this.mappedElement);
	}

	public void setValue(String value) {
		this.select.selectByVisibleText(value);
	}

	public String getValue() {
		var selected = this.select.getFirstSelectedOption().getText();
		return selected;
	}

	public String[] getOptions() {
		var options = this.select
				.getOptions()
				.stream()
				.map(WebElement::getText)
				.toArray(String[]::new);
		
		return options;
	}
}
