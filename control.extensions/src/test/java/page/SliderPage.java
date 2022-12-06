package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import controlextension.Slider;

public class SliderPage extends PageObjectBase {
	
	@FindBy(css="#sliderContainer")
	private WebElement slider;

	public SliderPage(WebDriver driver) {
		super(driver);
		this.driver.get("https://demoqa.com/slider");
	}

	public Slider getSlider() {
		return new Slider(this.slider);
	}
}
