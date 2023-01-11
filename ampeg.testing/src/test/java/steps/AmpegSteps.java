package steps;

import org.testng.Assert;

import foundation.CucumberTestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SVT410HLFPage;

public class AmpegSteps extends CucumberTestBase {
	
	//protected PageObject currentPage;
	//protected HomePage homePage;
	protected SVT410HLFPage indivualProductPage;

	@Given("user is on a home page")
	public void user_is_on_a_home_page() {
		setup();
		fromPages().homePage().navigate();
	}

	@When("user opens an individual amp product")
	public void user_opens_an_individual_amp_product_HLF410() {
		fromPages().homePage()
		.openProductPage()
		.openClassicSeriesBassHeads()
		.openSVT410HLF();
	}

	@Then("user will see artists endorsement")
	public void user_will_see_artists_endorsement() {
		String expected = "Bootsy Collins";
		String actualName = fromPages().svt410hlfpage()
				.getArtist();
		cleanup();
		Assert.assertEquals(actualName, expected, "Test should find artist name");
		
	}

	@When("user opens heritage category")
	public void user_opens_heritage_category() {
		fromPages().homePage()
		.openProductPage()
		.openHeritageSeriesBassHeads();
	}

	@When("user opens an individual amp product, 50th Anniversary SVT")
	public void user_opens_an_individual_amp_product_50th_anniversary_svt() {
		fromPages().heritagePage().openFirstLearnMore();
	}

	@Then("user will see product specifications")
	public void user_will_see_product_specifications() {
		String[] expectedStats = {"Preamp Tubes:"
		, "Driver Tubes:"
		, "Power Amp Tubes:"
		, "Output Power Rating:"
		, "Signal-to-Noise Ratio:"
		, "Maximum Gain:"
		, "Tone Controls"
		, "Channel One:"
		, "Channel Two:"
		, "Bass:"
		, "Midrange:"
		, "Treble:"
		, "Ultra Lo:"
		, "Ultra Hi:"};
		int statsFound = 0;
		
		String paragraph = fromPages().heritageSVTPage().getSpecifications();
		for(String stat : expectedStats) {
			if(paragraph.contains(stat)) {
				statsFound += 1;
			}
		}
		
		cleanup();
		Assert.assertTrue(statsFound > 6, "Prudct specifications should be found");

	}

	@When("user clicks {string}")
	public void user_clicks(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user will see a list of dealers for that product")
	public void user_will_see_a_list_of_dealers_for_that_product() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user will see the list of artists")
	public void user_will_see_the_list_of_artists() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on shopping cart symbol")
	public void user_clicks_on_shopping_cart_symbol() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user will see their cart with items in it")
	public void user_will_see_their_cart_with_items_in_it() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
