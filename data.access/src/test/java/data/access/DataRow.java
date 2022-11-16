package data.access;

public interface DataRow {
	String[] getData();
	String[] getColumns();
	String getValueFromColumn(int i);
	String getColumn(String columnName);
}
