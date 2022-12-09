import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadWriteTool {

	public static HashMap<String, String> getModelMakeMapFromFile(String filePath) throws IOException {
	  	var reader = new FileReader(filePath);
	  	var data = reader.read();	
	  	var quickMap = new HashMap<String,String>();
	  	var make = "";
	  	var model = "";
	  	var track = 0;
	  	
	  	while(data!=-1) {
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
	}

}
