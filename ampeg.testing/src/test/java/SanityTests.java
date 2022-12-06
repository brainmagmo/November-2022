
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTests {
  @Test
  public void canLaunchChromDriver() {
	  var chromeDpath = "C:\\Users\\trevo\\webdrivers\\chromedriver.exe";
	  var url = "https://www.selenium.dev/";
	  System.setProperty("webdriver.chrome.driver", chromeDpath);
  
	  var driver = new ChromeDriver();
	  driver.navigate().to(url);
	  var currentUrl = driver.getCurrentUrl();
	  
	  Assert.assertEquals(currentUrl, url, "the url should be successful if selenium is set up right.");
  
  
  }
}
