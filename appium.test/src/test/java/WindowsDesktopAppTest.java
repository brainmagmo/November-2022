import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsDesktopAppTest extends TestBase {

	public static WindowsDriver<WebElement> driver;

	@BeforeTest
	public void setup( ) {
		var caps = new DesiredCapabilities();
		caps.setCapability("platformVersion", "11");
		caps.setCapability("platformName", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		caps.setCapability("newCommandTimeout", 2000);
		driver = new WindowsDriver<>(getServiceUrl(), caps);
	}

	@AfterTest
	public void tearDown( ) {
		driver.quit();
	}

	@Test
	public void addition() {
		clickByName("One");
		clickByName("Plus");
		clickByName("Two");
		clickByName("Equals");

		Assert.assertEquals(driver
				.findElementByAccessibilityId("CalculatorResults").getText(),
				"Display is 3");
	}   

	@Test
	public void subtraction() {
		clickByName("Five");
		clickByName("Minus");
		clickByName("Three");
		clickByName("Equals");

		Assert.assertEquals(driver
				.findElementByAccessibilityId("CalculatorResults").getText(),
				"Display is 2");
	}

	@Test
	public void division() {
		clickByName("Eight");
		clickByName("Divide by");
		clickByName("Two");
		clickByName("Equals");
		
		Assert.assertEquals(driver
				.findElementByAccessibilityId("CalculatorResults").getText(),
				"Display is 4");
	}

	@Test
	public void multiplication() {
		clickByName("Three");
		clickByName("Multiply by");
		clickByName("Four");
		clickByName("Equals");

		Assert.assertEquals(driver
				.findElementByAccessibilityId("CalculatorResults").getText(),
				"Display is 12");
	}

	@Test
	public void sqrt() {
		clickByName("One");
		clickByName("Zero");
		clickByName("Zero");
		clickByName("Square root");

		Assert.assertEquals(driver
				.findElementByAccessibilityId("CalculatorResults").getText(), 
				"Display is 10");
	}

	private void clickByName(String name) {
		driver.findElementByName(name).click();    	
	}

	@Test
	private void canGetNames() {
		String[] expected_names = {
				"Open Navigation",
				"Keep on top",
				"Open history flyout",
				"Positive negative",
				"Clear all memory",
				"Memory recall",
				"Memory add",
				"Memory subtract",
				"Memory store",
				"Open memory flyout",
				"Percent",
				"Clear entry",
				"Clear",
				"Backspace",
				"Reciprocal",
				"Square",
				"Square root",
				"Divide by",
				"Multiply by",
				"Minus",
				"Plus",
				"Equals",
				"Zero",
				"One",
				"Two",
				"Three",
				"Four",
				"Five",
				"Six",
				"Seven",
				"Eight",
				"Nine",
				"Decimal separator",
		};

		var names = getButtonNames();

		for(var expected: expected_names) {
			Assert.assertTrue(names.contains(expected), 
					"We should find the button named " + expected);
		}
	}

	public List<String> getButtonNames() {
		var names = new ArrayList<String>();
		driver.findElementsByClassName("Button")
		.forEach(el -> 
		names.add(el.getAttribute("Name")));
		//names.forEach(name -> System.out.println(name));
		return names;
	}
}
