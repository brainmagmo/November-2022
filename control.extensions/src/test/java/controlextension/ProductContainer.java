package controlextension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductContainer extends ControlExtensionBase {

	public ProductContainer(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public void clickMore() {
		this.mappedElement.findElement(By.linkText("More"))
		.click();
	}

	
}
