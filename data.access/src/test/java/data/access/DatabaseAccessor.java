package data.access;

public interface DatabaseAccessor {
	
	String[] ExecuteSingleColumn(String sql);
	
	String ExecuteSingleCell(String sql);
	
	DataRow[] Execute(String sql);
	
	DataRow[] ExecuteCall(String sql, String[] outputNames);

	void start();
	
}
