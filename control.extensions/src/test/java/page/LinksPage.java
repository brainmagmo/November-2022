package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controlextension.Hyperlink;

public class LinksPage {

	private WebDriver driver;

	public LinksPage(WebDriver driver) {
		this.driver = driver;
		this.driver.get("https://demoqa.com/links");
	}

	public Hyperlink getLink(String label) {
		var link = this.driver.findElement(By.linkText(label));
		return new Hyperlink(link);
	}

	public String getResults() {
		var msg = this.driver.findElement(By.id("linkResponse")).getText();
		return msg;
	}

	public String getLinkClickResults(String label) {
		this.getLink(label).click();
		return getResults();
	}
}