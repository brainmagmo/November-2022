package foundation;

import org.openqa.selenium.WebDriver;

import page.*;

public class PageRepository {

	private WebDriver driver;
	private RadioPage radioPage;
	private SelectPage selectPage;
	private SliderPage sliderPage;
	private LinksPage linksPage;

	public PageRepository(WebDriver driver) {
		this.driver = driver;
	}

	public RadioPage getRadioButtonPage() {
		if(this.radioPage == null)
			this.radioPage = new RadioPage(this.driver);
		return this.radioPage;
	}
	
	public SelectPage getSelectPage() {
		if(this.selectPage == null)
			this.selectPage = new SelectPage(this.driver);
		return this.selectPage;
	}

	public SliderPage getSliderPage() {
		if(this.sliderPage == null)
			this.sliderPage = new SliderPage(this.driver);
		return this.sliderPage;
	}

	public LinksPage getLinksPage() {
		if(this.linksPage == null)
			this.linksPage = new LinksPage(this.driver);
		return this.linksPage;
	}
}
