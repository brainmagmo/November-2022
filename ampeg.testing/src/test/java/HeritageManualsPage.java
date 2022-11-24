import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeritageManualsPage extends PageObject {

	public HeritageManualsPage(WebDriver driver) {
		super(driver);
	}

	public PDFpage openFirstPDF() {
		find(By.xpath("//table/tbody/tr[1]/td[2]"))
		.click()
		;
		return new PDFpage(this.driver);
	}

}
