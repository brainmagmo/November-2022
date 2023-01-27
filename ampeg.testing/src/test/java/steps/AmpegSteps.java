package steps;

import java.util.List;

import org.testng.Assert;

import foundation.CucumberTestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SVT410HLFPage;

public class AmpegSteps extends CucumberTestBase {

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

	@When("user clicks Find a Dealer")
	public void user_clicks_Find_a_Dealer() {
		fromPages().heritagePage().clickFindDealer();
	}

	@When("user clicks Buy Now")
	public void user_clicks_Buy_Now() {
		fromPages().buyHeritagePage().clickBuyNow();
	}

	@Then("user will see a list of dealers for that product")
	public void user_will_see_a_list_of_dealers_for_that_product() {
		String[] expectedDealers = {"Musician's Friend",
				"Guitar Center",
				"Pitbull Audio",
				"zZounds",
				"Sweetwater",
				"Capital Music Gear",
				"Sam Ash Music",
		"American Musical Supply"};
		int dealersFound = 0;

		List<String> actualDealers = fromPages().buyHeritagePage().getRetialerNamesFromPopup();

		for(String eDealer: expectedDealers) {
			for(String aDealer : actualDealers) {
				if(aDealer.contains(eDealer)) {
					dealersFound++;
				}
			}
		}
		Assert.assertTrue(dealersFound > 3, "user should be able to find product dealers");
		cleanup();
	}

	@When("user clicks on Artists")
	public void user_clicks_on_Artists() {
		fromPages().homePage().openArtists();
	}

	@Then("user will see the list of artists")
	public void user_will_see_the_list_of_artists() {
		String[] expectedArtists = {
				"SEYE ADELEKAN",
				"JUAN ALDERETE", "BRIAN ALLEN", "EMMA ANZAI",
				"WAYNE BANKS", "JACK BATES", "HAYLEY JANE BATT", 
				"CHRIS BEATTIE","GEORGE M. BIONDO",
				"TOD MICHAEL BOWERS","RANDY BRADBURY",
				"LENNY BRADFORD","MICHAEL BRADFORD",
				"REX BROWN","ADEN BUBECK","HUNTER BURGAN",
				"JON BUTTON","JUAN CALLEROS","SUNSHINE CANTU",
				"LIZA CARBÉ","TYLER CARROLL","CHI CHENG",
				"AL CISNEROS","ANDREW CICHON","STANLEY CLARK",
				"STEVE COOK","DENNIS CROUCH","SHERYL CROW",
				"MICHAEL D'AMICO","GRAHAM DELOACH","GAIL ANN DORSEY",
				"TOBIN ESPERANCE","STEVE FOSSEN","DAVE FOWLER",
				"NIKOLAI FRAITURE","VINCEN GARCIA","EVA GARDNER",
				"JON E. GEE","WYLIE GELBER","BOB GLAUB","TRACY GOODE",
				"BERNARDO GOSARIC","BRUCE HALL","JASON HARDIN",
				"ROBBIE HARRINGTON","DAVID HARTLEY","LEE HENDRICKS",
				"PETER HOOK","HUTCH HUTCHINSON","MIKE INEZ",
				"JIMMY JAMES","JERRY JEMMOTT","DARRYL JENIFER",
				"DARRYL JONES","ZEV KATZ","HARMONI KELLEY",
				"MASA KOBAYASHI","CONRAD KORSCH","DAVE LARUE",
				"TIM LEFEBVRE","TONY LEVIN","BRENDON LOVE",
				"DAN MAINES","MATT MALLEY","NATHEN MAXWELL",
				"MARCO MENDOZA","MARK MENGHI","ROBERT MERCURIO",
				"PAT MCCARTHY","SEAN MCNABB","JIMMY MILLER",
				"NIKKI MONNINGER","DINO \"THE AMPEG GUY\" MONOXELOS",
				"DANNY MORRIS","DIEGO NAVAIRA","JASON NEWSTED",
				"TANYA O'CALLAGHAN","JENN OBERLE","SCOTT OWEN",
				"JUSTIN PEARSON","RICKY PHILLIPS","JEFF PILSON",
				"JIMI \"JAZZ\" PRESCOTT","LEX PRICE","TARAS PRODANIUK",
				"JON RESHARD","EMILY RETSAS","DAVEY RIMMER",
				"SIMON RIX","LEE ROCKER","RICK \"THE BASS PLAYER\" ROSAS",
				"ABBI ROTH","TRIPPER RYDER","ARMAND SABAL-LECCO",
				"MIKI SANTAMARIA","RUDY SARZO","SCHMIER (MARCEL SCHIRMER)",
				"SHAWN SCRUGGS","DAMIEN SISSON","DEREK SMALLS","PHIL SOUSSAN",
				"CHRIS SQUIRE","PABLO STENNETT","BRAD STEWART","BOB ST. LAURENT",
				"JOHNNY STANTON","JOHN STIRRATT","ROBBIE TAKAC","NICKI TEDESCO",
				"MICHAEL TORRES","ABBY TRAVIS","ROBERT TRUJILLO","TÉJA VEAL",
				"ROB WASSERMAN","ROGER WATERS","CLIFF WILLIAMS","LIAM WILSON",
				"ELOISE WONG","CHUCK WRIGHT","CODY WRIGHT","CHRIS WYSE"
		};
		int foundArtists = 0;

		List<String> artists = fromPages().artistsPage().getArtists();
		for(String eDealer: expectedArtists) {
			for(String aDealer : artists) {
				if(aDealer.contains(eDealer)) {
					foundArtists++;
				}
			}
		}
		Assert.assertTrue(foundArtists > 10, "User should be able to find endorsing artsts");
		cleanup();
	}

	@When("user clicks on shopping cart symbol")
	public void user_clicks_on_shopping_cart_symbol() {
		fromPages().homePage().openShoppingCart();

	}

	@Then("user will see their cart with items in it")
	public void user_will_see_their_cart_with_items_in_it() {
		boolean sawCart = fromPages().shoppingCartPage().userSeesCart();
		Assert.assertTrue(sawCart, "User should be able to see their cart with items in it");
		cleanup();
	}

}
