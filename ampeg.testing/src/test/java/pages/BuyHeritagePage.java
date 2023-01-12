package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyHeritagePage extends PageObject {
	@FindBy(linkText="BUY NOW")
	WebElement buyNowLink;

	public BuyHeritagePage(WebDriver driver) {
		super(driver);
	}

	public BuyHeritagePage clickBuyNow() {
		buyNowLink.click();
		return this;
	}

	public List<String> getRetialerNamesFromPopup() {
		var namesElems = this.driver.findElements(By.cssSelector(".oma-name"));
		List<String> namesStr = namesElems.stream().map(name -> name.getText()).collect(Collectors.toList());
		return namesStr;
	}
}
