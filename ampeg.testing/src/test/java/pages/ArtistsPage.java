package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistsPage extends PageObject {

	public ArtistsPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getArtists() {
		var elms = this.driver.findElements(By.className("nombre"));
		var nombres = elms.stream()
				.map(elm -> elm.getAttribute("innerText"))
				.collect(Collectors.toList());
		return nombres;
	}

}
