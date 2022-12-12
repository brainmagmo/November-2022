package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import controlextension.Dropdown;
import controlextension.MultiSelect;

public class SelectPage extends PageObjectBase {

	@FindBy(css="#oldSelectMenu")
	private WebElement dropdownElement;
	private Dropdown dropdown;
	@FindBy(css="#cars")
	private WebElement multiSelectElement;
	private MultiSelect multiSelect;

	public SelectPage(WebDriver driver) {
		super(driver);
		this.driver.get("https://demoqa.com/select-menu");
	}

	public Dropdown getSelectDropdown() {
		if (this.dropdown == null)
			this.dropdown = new Dropdown(this.dropdownElement);
		return this.dropdown;
	}

	public MultiSelect getMultiselect() {
		if (this.multiSelect == null)
			this.multiSelect = new MultiSelect(this.multiSelectElement);
		return this.multiSelect;
	}

	public SelectPage setSingleSelectValue(String color) {
		getSelectDropdown()
			.setValue(color);
		return this;
	}

	public String getSingleSelectValue() {
		return getSelectDropdown()
				.getValue();

	}
}
