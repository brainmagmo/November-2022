package data.access;

import java.util.ArrayList;
import java.util.Arrays;

public class StringRow implements DataRow {
	
	private String[] info;
	private String[] columns;
	
	public StringRow(ArrayList<String> cols, ArrayList<String> data) {
		this.info = data.toArray(String[]::new);
		this.columns = cols.toArray(String[]::new);
	}
	public StringRow(String[] cols, String[] data) {
		this.columns = cols;
		this.info = data;
	}
	
	@Override
	public String[] getData() {
		return info;
	}
	@Override
	public String[] getColumns() {
		return columns;
	}
	@Override
	/*
	 * columns are indexed starting from 1
	 */
	public String getValueFromColumn(int i) {
		return info[i-1];
	}
	@Override
	public String getColumn(String columnName) {
		int index = Arrays.binarySearch(columns, columnName);
		if(index < 0) {
			return null;
		}
		return info[index];
	}

}
