package data.access;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultDataRow implements DataRow {

	private ArrayList<String> Columns;
	private HashMap<String,String> data;
	
	public ResultDataRow() {
		this.Columns = new ArrayList<String>();
		this.setData(new HashMap<String,String>());
	};
	
	@Override
	public String[] getData() {
		return data.values().toArray(String[]::new);
	}

	@Override
	public String[] getColumns() {
		return data.keySet().toArray(String[]::new);
	}

	@Override
	/*
	 * columns are indexed starting from 1
	 */
	public String getValueFromColumn(int i) {
		return data.get(Columns.get(i-1));
	}

	@Override
	public String getColumn(String columnName) {
		return data.get(columnName);
	}
	
	public int size() {
		return Columns.size();
	}

	public void setData(HashMap<String,String> data) {
		this.Columns = new ArrayList<String>();
		this.data = new HashMap<String,String>();
		this.Columns.addAll(data.keySet());
		this.data = data;
	}
	
	public void setColumn(String columnName, String value) {
		this.Columns.add(columnName);
		this.data.put(columnName, value);
	}
}
