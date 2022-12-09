import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadWriteTool {

	public static HashMap<String, String> getModelMakeMapFromFile(String filePath) {
		FileReader reader;
		var quickMap = new HashMap<String,String>();
		var make = "";
		var model = "";
		var track = 0;
		
		try {
			reader = new FileReader(filePath);
			var data = reader.read();	

			while(data != -1) {
				char c = (char) data;

				if(c == '\n') {
					quickMap.put(model.trim(), make.trim());
					make = "";
					model = "";	  		
					track = 0;
					data = reader.read();
					continue;
				}
				if(c == ',') {
					track += 1;
					data = reader.read();
					continue;
				}

				if(track == 0) {
					make += c;
				}	  		
				if(track == 1) {
					model += c;
				}

				data = reader.read();
			}

			quickMap.remove("Model");	  
			reader.close();
			return quickMap;			
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
