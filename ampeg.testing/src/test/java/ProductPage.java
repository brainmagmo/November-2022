import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public ClassicSeriesPage openClassicSeriesBassHeads() {
		find(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"))
			.click();
		return new ClassicSeriesPage(this.driver);
	}

	public HeritageSeriesPage openHeritageSeriesBassHeads() {
		find(By.cssSelector("img[alt='Heritage Series: Bass heads & enclosures']"))
		.click()
		;
		return new HeritageSeriesPage(this.driver);
	}
	
}
