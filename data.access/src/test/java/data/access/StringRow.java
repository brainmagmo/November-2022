package data.access;

import java.util.ArrayList;

public class StringRow implements DataRow {
	
	private String[] info;
	
	public StringRow(ArrayList<String> data) {
		this.info = (String[]) data.toArray();
	}
	public StringRow(String[] data) {
		this.info = data;
	}
	
	@Override
	public String[] getData() {
		return info;
	}

}
