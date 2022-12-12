import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class ReadWriteTests {
	private static String FILEPATH = "C:\\Users\\trevo\\git\\November-2022\\read.write\\src\\test\\resources\\basses.csv";

	@Test
	public void canReadFile() {
		FileReader reader = null;
		try { reader = new FileReader(FILEPATH); } catch (FileNotFoundException e) {}
		Assert.assertNotNull(reader, "the file should be able to be read");
	}

	@Test 
	public void canReadintoHash() {
		var expectedMap = new HashMap<String,String>();
		expectedMap.put("Model", 	"Make"	);
		expectedMap.put("BB500", 	"Yamaha"	);
		expectedMap.put("Corvette", "Warwick"	);
		expectedMap.put("Thumb", 	"Warwick"	);
		expectedMap.put("Precision","Fender"	);
		expectedMap.put("Streamer", "Warwick"	);
		expectedMap.put("Jazz", 	"Fender"	);

		var actaulMap = ReadWriteTool.getModelMakeMapFromFile(FILEPATH);

		Assert.assertEquals(actaulMap, expectedMap, "The CSV should be read and mapped");
	}

	@Test 
	public void canHydrate() {
		var expectedBasses = new ArrayList<Bass>();
		expectedBasses.add(new Bass("BB500", 	"Yamaha"	));
		expectedBasses.add(new Bass("Corvette", "Warwick"	));
		expectedBasses.add(new Bass("Thumb", 	"Warwick"	));
		expectedBasses.add(new Bass("Precision","Fender"	));
		expectedBasses.add(new Bass("Streamer", "Warwick"	));
		expectedBasses.add(new Bass("Jazz", 	"Fender"	));

		var actualBasses = ReadWriteTool.getBassListFromFile(FILEPATH);

		Assert.assertTrue(actualBasses.containsAll(expectedBasses) &&
				expectedBasses.containsAll(actualBasses), 
				"The Basses should be hydrated from the csv.");
	}
}
