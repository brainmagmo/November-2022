package data.access;


public interface DatabaseAccessor {
	
	String[] executeSingleColumn(String sql);
	
	String executeSingleCell(String sql);
	
	DataRow[] executeQuery(String sql);
	
	DataRow[] executeCall(
			String call, 
			String[] paramNames, Object[] inputs, int[] inputTypes, 
			int[] outputTypes, String[] outputNames 
			);
	
	
	
}
