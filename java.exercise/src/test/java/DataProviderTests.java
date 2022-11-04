import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
  @Test
  public void canGetStateName() {
	  //arrange
	  var expectedState = "Texas";
	  //act
	  var actualState = States.Texas.Name;
	  //assert
	  Assert.assertEquals(actualState, expectedState, "The state name should be returned.");
  }
}
