import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ReadWriteTool {


	public static HashMap<String, String> getModelMakeMapFromFile(String filePath) {
		var map = new HashMap<String,String>();
		try {
			var in = new BufferedReader(new FileReader(filePath));
			
			in.lines().forEach((line) -> {
				String[] lineItems = line.split(",");
				map.put(lineItems[1].trim(), lineItems[0].trim());
			});;
			map.remove("Model");	  
			in.close();
			return map;			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Bass> getBassListFromFile(String FILEPATH) {
		List<Bass> basses = null;
		try {
			basses = new CsvToBeanBuilder<Bass>(new FileReader(FILEPATH))
				       .withType(Bass.class)
				       .build()
				       .parse();
			return basses;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return basses;
	}

}
