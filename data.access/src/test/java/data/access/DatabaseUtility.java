package data.access;
import java.sql.*;
import java.util.ArrayList;


public class DatabaseUtility implements DatabaseAccessor {

	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
	static final String USER = "root";
	static final String PASS = "password";

	public DataRow[] executeQuery(String sql) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			DataRow[] dra = null;
			try {
				dra = ResultSetToDataMatrix(rs);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return dra;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public String executeSingleCell(String sql) {

		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			String s = null;
			
			if(rs.next()) {
				s=  rs.getString(1);
			}
			
			rs.close();
			return s;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String[] executeSingleColumn(String sql) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			ArrayList<String> outputList = new ArrayList<String>();
			String s;
			
			while(rs.next()) {
				s = rs.getString(1);
				outputList.add(s);
			}
			
			rs.close();
			return outputList.toArray(new String[outputList.size()]);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public DataRow[] executeCall(
			String call, 
			String[] paramNames, Object[] inputs, int[] inputTypes, 
			String[] outputNames, int[] outputTypes 
			) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			CallableStatement stmt = conn.prepareCall(call);) {
			
			for (int i = 0 ; i < inputs.length ; i++) {
				stmt.setObject(paramNames[i], inputs[i], inputTypes[i]);
			}
			
			for (int i = 1 ; i <= outputTypes.length ; i++) {
				stmt.registerOutParameter(i+inputs.length, outputTypes[i-1]);
			}
			
			boolean b = stmt.execute();
			if(b) {
				
				ResultSet rs = stmt.getResultSet();
				
				DataRow[] dra = null;
				try {
					dra = ResultSetToDataMatrix(rs);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return dra;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public static DataRow[] ResultSetToDataMatrix(ResultSet rs) {
		
		try {
			
			int numberOfCols = rs.getMetaData().getColumnCount();
			ArrayList<DataRow> outputList = new ArrayList<DataRow>();
			
			while(rs.next()) {
				String[] currentRowData = new String[numberOfCols];
				
				for(int i = 0; i < numberOfCols; i++) {
					currentRowData[i] = rs.getString(i+1);
				}
				
				outputList.add(new StringRow(currentRowData));
			}
			
			rs.close();			
			return outputList.toArray(new DataRow[outputList.size()]);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}


}
