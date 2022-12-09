import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

	public static ArrayList<Bass> getBassListFromFile(String fILEPATH) {
		var bassList = new ArrayList<Bass>();

		getModelMakeMapFromFile(fILEPATH)
		.forEach((model, make) -> {
			bassList.add(new Bass(model, make));
		});

		return bassList;
	}

}
