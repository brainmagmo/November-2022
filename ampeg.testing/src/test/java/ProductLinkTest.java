import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductLinkTest extends AmpegTest {
	@Test
	public void ensureArtistOnProductDetailsPage() {
		
		String expected = "Bootsy Collins";

		String actualName = new HomePage(this.driver)
				.openProductPage()
				.openClassicSeriesBassHeads()
				.openSVT410HLF()
				.getArtist();		

		Assert.assertEquals(actualName, expected, "Test should find artist name");
	}

	@Test
	public void downloadUserManual() {
		
		String expectedURL = "https://ampeg.com/data/6/0a020a40dc385e0b9cc618bd0/application/pdf/Heritage%2050th%20Anniversary%20SVT%20Quick%20Start%20Guide%20-%20English%20.pdf";

		String actual = new HomePage(this.driver)
			.openProductPage()
			.openHeritageSeriesBassHeads()
			.openFirstLearnMore()
			.openManuals()
			.openFirstPDF()
			.getURL();			

		Assert.assertEquals(actual,expectedURL,"Test should find pull up the pdf for the manual");
	}

	@Test
	public void addItemToShoppingCart() {

		String expected = "1";
		
		String actualText = new HomePage(this.driver)
				.openShop()
				.openShirts()
				.openBlackTee()
				.addXLtoCart()
				.getCartCount();				

		Assert.assertEquals(actualText,expected,"Test should find that items were visibly added to cart");
	}

	@Test
	public void verifyMissingFile() {

		String expected = ""
				+ "We're sorry, the page you are looking for is currently unavailable\n"
				+ "Please try again later";

		
		String actualText = new HomePage(this.driver)
				.openTechnicalLibrary()
				.openSchematics()
				.openESeries()
				.openEchoTwin()
				.openSchematicPart1()
				.getRegularText();
		
		Assert.assertEquals(actualText,expected,"Test should find dead link page");
	}

}
