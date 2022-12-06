package controlextension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect extends Dropdown{
	
	public MultiSelect(WebElement mappedElement) {
		super(mappedElement);
		this.select = new Select(mappedElement);
	}
	
	public void select(String value) {
		this.setValue(value);
	}
	
	public String[] getSelected() {		
		var selected = this.select
				.getAllSelectedOptions()
				.stream()
				.map(WebElement::getText)
				.toArray(String[]::new);
				
		return selected;
	}
}
