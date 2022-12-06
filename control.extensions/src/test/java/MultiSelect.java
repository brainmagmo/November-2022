import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect extends ControlExtensionBase {
	
	private Select select;

	public MultiSelect(WebElement mappedElement) {
		this.select = new Select(mappedElement);
	}
	
	public void select(String value) {
		this.select.selectByVisibleText(value);
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
