import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ReadWriteTool {


	public static HashMap<String, String> getModelMakeMapFromFile(final String FILEPATH) throws CsvValidationException {
		var map = new HashMap<String,String>();
		try {
		     CSVReader reader = new CSVReaderBuilder(new FileReader(FILEPATH)).build();
		     String [] nextLine;
		     while ((nextLine = reader.readNext()) != null) {
		        System.out.println(nextLine[0] + nextLine[1]);
		        map.put(nextLine[1], nextLine[0]);
		     }
			return map;			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Bass> getBassListFromFile(final String FILEPATH) {
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
