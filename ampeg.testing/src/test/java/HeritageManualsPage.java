import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeritageManualsPage extends PageObject {
	
	@FindBy(how=How.XPATH , using="//a[@class='ext_track']")
	WebElement pdfLink;

	public HeritageManualsPage(WebDriver driver) {
		super(driver);
	}

	public PDFpage openFirstPDF() {
		pdfLink.click();
		return new PDFpage(this.driver);
	}

}
