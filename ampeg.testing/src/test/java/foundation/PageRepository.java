package foundation;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageRepository {
	WebDriver driver;
	PageRepository(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage homePage() {
		return new HomePage(this.driver);
	}
	public SVT410HLFPage svt410hlfpage() {
		return new SVT410HLFPage(this.driver);
	}
	public HeritageSeriesPage heritagePage() {
		return new HeritageSeriesPage(this.driver);		
	}
	public Heritage50thAnniversarySVTPage heritageSVTPage() {
		return new Heritage50thAnniversarySVTPage(this.driver);	
	}

	
}
