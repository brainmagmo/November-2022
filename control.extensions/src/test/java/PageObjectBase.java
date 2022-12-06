import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;

	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		
		InitPageFactory();
	}

	private void InitPageFactory() {
		PageFactory.initElements(this.driver, this);
	}
}