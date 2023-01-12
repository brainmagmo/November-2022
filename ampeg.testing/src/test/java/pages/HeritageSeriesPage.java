package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeritageSeriesPage extends PageObject {
	
	@FindBy(how=How.CSS , using="#first-prod div.title a")
	WebElement learnMoreLink;
	@FindBy(css=".find-dealer-container a")
	WebElement dealerLink;
	
	public HeritageSeriesPage(WebDriver driver) {
		super(driver);
	}

	public Heritage50thAnniversarySVTPage openFirstLearnMore() {
		learnMoreLink.click();
		return new Heritage50thAnniversarySVTPage(this.driver);
	}
	
	public BuyHeritagePage clickFindDealer() {
		dealerLink.click();
		return new BuyHeritagePage(this.driver);
	}

}
