package data.access;

import org.testng.Assert;
import org.testng.annotations.*;

public class JdbcTests {
	
	private DatabaseAccessor accessor;
	private SakilaQueries sQueries;

	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility();
		this.sQueries = new SakilaQueries(this.accessor);
	}
	
	//A1. Get 10 cities in descending alphabetical order.
	@Test
	public void canGetCities() {
		var QUERY = "select * from sakila.city order by city desc limit 10;";
		var result = ExecuteQuery(QUERY);
		var expected = "";
		Assert.assertEquals(result, expected);
	}
	
	//B3. Get the highest payment amount.
	@Test
	public void canGetHighestPayment() {
		var result = this.sQueries.getHighestPayment();
		var expected = "11.99";
		Assert.assertEquals(result, expected);
	}
	
	//C6. Use a View to get the film info for actor Bob Fawcett.
	@Test
	public void canUseView() {
		var result = this.sQueries.getFilmInfo("Bob Fawcett");
		var expected = "Action: DARN FORRESTER; "
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
		Assert.assertEquals(result, expected);
	}
	
	//D7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
	@Test
	public void canUseStoredProc() {
		String[] result = this.sQueries.getInventoryIds("Alien Center", 2);
		String[] expected = {"73","74","75","76"};
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void canStart() {
		accessor.start();
	}

	@Test
	public void canAccessDataBase (){
		var result = ExecuteQuery("sql");
		Assert.assertNotNull(result);
	}

	private DataRow[] ExecuteQuery(String sql) {
		return this.accessor.Execute(sql);
	}
	
}
