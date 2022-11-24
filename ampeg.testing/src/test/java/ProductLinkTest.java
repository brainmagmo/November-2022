import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductLinkTest extends AmpegTest {
	@Test
	public void ensureArtistOnProductDetailsPage() {
		String expected = "Bootsy Collins";

		String actualName = new HomePage(this.driver)
				.openProductPage()
				.openClassicSeriesBassHeads()
				.openSVT410HLF()
				.getArtist();
		;

		Assert.assertEquals(actualName, expected, "Test should find artist name");
	}

	@Test
	public void downloadUserManual() {
		String expectedURL = "https://ampeg.com/data/6/0a020a40dc385e0b9cc618bd0/application/pdf/Heritage%2050th%20Anniversary%20SVT%20Quick%20Start%20Guide%20-%20English%20.pdf";
		/*
		 * 
		 *1) Click 'Products' from top bar or from hamburger drop down
		 *2) Click the first series, 'Heritage Series'
		 *3) Click 'Learn More' under the first product, 'Heritage 50th Anniversary SVT'
		 *4) Scoll down to end of article and click 'Manuals'
		 *5) Click the first pdf icon in the table, row 'Heritage 50th Anniversary SVT Quick Start Guide', column 'English'
		 *6) Download the pdf by clicking the down arrow in top right (SKIPPING THIS STEP)
		 */

		find(By.cssSelector("a[title='Products']"))
		.click()
		;

		find(By.cssSelector("img[alt='Heritage Series: Bass heads & enclosures']"))
		.click()
		;

		//Learn Mode
		find(By.cssSelector("#first-prod div.title a"))
		.click()
		;

		find(By.linkText("MANUALS"))
		.click()
		;

		find(By.xpath("//table/tbody/tr[1]/td[2]"))
		.click()
		;

		String actual = this.driver.getCurrentUrl();

		Assert.assertEquals(actual,expectedURL,"Test should find pull up the pdf for the manual");
	}

	@Test
	public void addItemToShoppingCart() {
		/*
		 * 1) Scroll down and click 'Shop Now' below 'Featured Artist' and above the youtube video
		 * 2) Mousover 'Merch' at the top right then click the first option 'Shirts'
		 * 3) Click the image of the last product titled 'Classic Tee (Black)'
		 * 4) Click the Size drop down and then click 'XL'
		 * 5) Click blue 'ADD TO CART' button
		 */
		String expected = "1";

		find(By.linkText("SHOP NOW"))  
		.click()
		;
		Actions mouse = new Actions(this.driver);
		WebElement merch = find(By.cssSelector("a#ui-id-5"));
		mouse.moveToElement(merch).perform();
		find(By.cssSelector("a#ui-id-15"))
		.click()
		;
		find(By.cssSelector("img[alt='Classic Tee (Black)']"))
		.click()
		;
		new Select(find(By.cssSelector("select#attribute178")))
		.selectByVisibleText("XL")
		;
		find(By.cssSelector("button#product-addtocart-button"))
		.click()
		;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actual = find(By.cssSelector("span.counter-number"))
				.getText()
				;

		Assert.assertEquals(actual,expected,"Test should find that items were visibly added to cart");
	}

	@Test
	public void verifyMissingFile() {
		/*
		 * 1) Click 'Technical Library' at the bottom of the page to load ui-bare file directory
		 * 2) Click 'Schematics/'
		 * 3) Click 'E Series/'
		 * 4) Click 'ET-1B (Echo Twin)/'
		 * 5) Click 'Echo Twin Schematic Part 1.gif'
		 */
		String expected = ""
				+ "We're sorry, the page you are looking for is currently unavailable\n"
				+ " Please try again later"
				;

		find(By.linkText("Technical Library"))
		.click()
		;
		find(By.linkText(" Schematics/"))
		.click()
		;
		find(By.linkText(" E Series/"))
		.click()
		;
		find(By.linkText(" ET-1 (Echo Twin)/"))
		.click()
		;
		find(By.linkText(" Echo Twin Schematic Part 1.gif"))
		.click()
		;
		String actual = find(By.tagName("p"))
				.getText()
				;

		Assert.assertEquals(actual,expected,"Test should find dead link page");
	}

}
