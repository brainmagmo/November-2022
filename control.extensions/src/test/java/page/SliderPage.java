package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import controlextension.Slider;

public class SliderPage extends PageObjectBase {
	
	@FindBy(css="#sliderContainer")
	private WebElement sliderElement;
	
	private Slider slider;

	public SliderPage(WebDriver driver) {
		super(driver);
		this.driver.get("https://demoqa.com/slider");
		this.slider = null;
	}

	public Slider getSlider() {
		if(this.slider == null)
			this.slider = new Slider(this.sliderElement);
		return this.slider;
	}

	public SliderPage setSliderValue(int number) {
		getSlider().setValue(number);
		return this;
	}
	

	public SliderPage setSliderValue(String number) {
		getSlider().setValue(number);
		return this;
	}

	public String getSliderValue() {
		return getSlider().getValue();
	}
	
	
}
