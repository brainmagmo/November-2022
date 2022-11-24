import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	  
	  Assert.assertEquals(actualName,expected,"Test should find artist name");
  }
  
  @Test
  public void downloadUserManual() {
	  String expected = "Bootsy Collins";
	  
	  WebElement link;
	  link = find(By.cssSelector("a[title='Products']"));
	  link.click();
	  link = find(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
	  link.click();
	  link = find(By.linkText("SVT-410HLF"));
	  link.click();
	  String actual = find(By.cssSelector("#artist b")).getText();
	  
	  Assert.assertEquals(actual,expected,"Test should find artist name");
  }
  
  @Test
  public void addItemToShoppingCart() {
	  String expected = "Bootsy Collins";
	  
	  WebElement link;
	  link = find(By.cssSelector("a[title='Products']"));
	  link.click();
	  link = find(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
	  link.click();
	  link = find(By.linkText("SVT-410HLF"));
	  link.click();
	  String actual = find(By.cssSelector("#artist b")).getText();
	  
	  Assert.assertEquals(actual,expected,"Test should find artist name");
  }
  
  @Test
  public void verifyMissingFile() {
	  String expected = "Bootsy Collins";
	  
	  WebElement link;
	  link = find(By.cssSelector("a[title='Products']"));
	  link.click();
	  link = find(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
	  link.click();
	  link = find(By.linkText("SVT-410HLF"));
	  link.click();
	  String actual = find(By.cssSelector("#artist b")).getText();
	  
	  Assert.assertEquals(actual,expected,"Test should find artist name");
  }

}
