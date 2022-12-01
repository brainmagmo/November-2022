import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends PageObject {
	
	@FindBy(how=How.CSS , using="img[alt='Classic Series: Bass heads & enclosures']")
	WebElement classicSeriesLink;
	@FindBy(how=How.CSS , using="img[alt='Heritage Series: Bass heads & enclosures']")
	WebElement heritageSeriesLink;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public ClassicSeriesPage openClassicSeriesBassHeads() {
		classicSeriesLink.click();
		return new ClassicSeriesPage(this.driver);
	}

	public HeritageSeriesPage openHeritageSeriesBassHeads() {
		heritageSeriesLink.click();
		
		return new HeritageSeriesPage(this.driver);
	}
	
}
