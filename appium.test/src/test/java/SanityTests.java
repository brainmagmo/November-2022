import org.testng.annotations.Test;

public class SanityTests extends TestBase {
	@SuppressWarnings("unused")
	@Test
	public void canUseVar() {
		String myString = "Taylo  rDennis";
		var myVarString = "Dennis";			  
	}
}
