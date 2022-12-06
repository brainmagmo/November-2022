package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import controlextension.Dropdown;
import controlextension.MultiSelect;

public class SelectPage extends PageObjectBase {

	@FindBy(css="#oldSelectMenu")
	private WebElement dropdown;
	@FindBy(css="#cars")
	private WebElement multiSelect;

	public SelectPage(WebDriver driver) {
		super(driver);
		this.driver.get("https://demoqa.com/select-menu");
	}

	public Dropdown getSelectDropdown() {
		return new Dropdown(this.dropdown);
	}

	public MultiSelect getMultiselect() {
		return new MultiSelect(this.multiSelect);
	}
}
