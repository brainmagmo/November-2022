import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedStateName = "Texas";
		var actualStateName = States.Texas.Name;
		Assert.assertEquals(actualStateName, expectedStateName, "The state name should be returned.");
	}

	@Test
	public void canGetStateAbbreviation() {

		var expectedStateAbbr = "LA";
		var actualStateAbbr = States.Louisiana.Abbreviation;
		Assert.assertEquals(actualStateAbbr, expectedStateAbbr, "The state abbreviation" + 
		" should be returned.");

	}
	

	@Test
	public void canGetStateNameFromObjectMother() {
		var expectedState = "Texas";
		var actualState = getState(LocationObjectMothers.Houston()).Name;
		Assert.assertEquals(actualState, expectedState, "The state associated " +
		"with the city should be returned");
	}
	
	@Test
	public void canGetStateName2() {
		var expectedStateName = "California";
		var actualStateName = States.California.Name;
		Assert.assertEquals(actualStateName, expectedStateName, "The state name should be returned.");
	}

	@Test
	public void canGetStateAbbreviation2() {

		var expectedStateAbbr = "NY";
		var actualStateAbbr = States.NewYork.Abbreviation;
		Assert.assertEquals(actualStateAbbr, expectedStateAbbr, "The state abbreviation" + 
		" should be returned.");

	}
	

	@Test
	public void canGetStateNameFromObjectMother2() {
		var expectedState = "California";
		var actualState = getState(LocationObjectMothers.SanDiego()).Name;
		Assert.assertEquals(actualState, expectedState, "The state associated " +
		"with the city should be returned");
	}

	private State getState(LocationObjectMother mother) {
		// TODO Auto-generated method stub
		return mother.State;
	}
}
