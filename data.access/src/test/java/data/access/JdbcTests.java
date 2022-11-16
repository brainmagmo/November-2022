package data.access;

import org.testng.Assert;
import org.testng.annotations.*;

public class JdbcTests {
	
	private SakilaQueries sQueries;

	@BeforeMethod
	public void Setup() {
		this.sQueries = new SakilaQueries();
	}
	
	//A1. Get 10 cities in descending alphabetical order. PASS
	@Test
	public void canGetCities() {
		
		String[] expected = {
				"Ziguinchor",
				"Zhoushan",
				"Zhezqazghan",
				"Zeleznogorsk",
				"Zaria",
				"Zapopan",
				"Zaoyang",
				"Zanzibar",
				"Zalantun",
				"Yuzhou"
				};
		
		var result = this.sQueries.getCities();
		
		Assert.assertEquals(result, expected, "the query should return 10 cities");
	}
	
	//B3. Get the highest payment amount. PASS
	@Test
	public void canGetHighestPayment() {
		
		String expected = "11.99";
		
		var result = this.sQueries.getHighestPayment();
		
		Assert.assertEquals(result, expected, "the query should return a payment amount");
	}
	
	//C6. Use a View to get the film info for actor Bob Fawcett. PASS
	@Test
	public void canUseView() {
				
		String expected = "Action: DARN FORRESTER; "
				+ "Animation: DARES PLUTO, LAWLESS VISION, OSCAR GOLD; "
				+ "Children: CIRCUS YOUTH; "
				+ "Classics: DYNAMITE TARZAN; "
				+ "Comedy: CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; "
				+ "Documentary: ADAPTATION HOLES, PELICAN COMFORTS; "
				+ "Drama: JACKET FRISCO, SCORPION APOLLO; "
				+ "Family: HOMICIDE PEACH; "
				+ "Games: DAZED PUNK; "
				+ "Horror: ACE GOLDFINGER; "
				+ "Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; "
				+ "New: CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; "
				+ "Sci-Fi: RAGING AIRPLANE; "
				+ "Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE"
				;
	
		var result = this.sQueries.getFilmInfo("Bob Fawcett");
	
		Assert.assertEquals(result, expected, "the query should return a film info string");
	}
	
	//D7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. PASS 
	@Test
	public void canUseStoredProc() {
		
		String[] expected = {"73","74","75","76"};
		
		var result = this.sQueries.getInventoryIds("Alien Center", 2);
		
		Assert.assertEquals(result, expected, "the query should return inventory IDs");
		
	}

}
