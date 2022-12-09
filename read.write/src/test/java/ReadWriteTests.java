import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadWriteTests {
  @Test
  public void canUseVar() {
	  var jon = "";
	  jon = jon + jon;
  }
  
  @Test 
  public void canReadintoHash() throws IOException {
	  	Map<String,String> expectedMap = new HashMap<String,String>();
	  	expectedMap.put("Corvette", "Warwick");
	  	expectedMap.put("Thumb", "Warwick");
	  	expectedMap.put("Streamer", "Warwick");
	  	expectedMap.put("Precision", "Fender");
	  	expectedMap.put("Jazz", "Fender");
	  	expectedMap.put("BB500", "Yamaha");
	  		  	
		HashMap<String,String> readData = ReadWriteTool.getModelMakeMapFromFile("C:\\Users\\trevo\\eclipse-workspace\\read.write\\src\\test\\resources\\basses.csv");

	  	Assert.assertEquals(expectedMap, readData);
  }
  
  @Test 
  public void canHydrate() {
	  
  }
}
