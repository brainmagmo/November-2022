package data.access;
import java.sql.*;
import java.util.ArrayList;


public class DatabaseUtility implements DatabaseAccessor {

	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
	static final String USER = "root";
	static final String PASS = "password";
	static final String QUERY1 = "SELECT staff_id, first_name, last_name FROM staff";

	public void start() {
		// Open a connection
		try(
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY1);
				) {
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				System.out.print("ID: " + rs.getInt("staff_id"));
				System.out.print(", First: " + rs.getString("first_name"));
				System.out.println(", Last: " + rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public DataRow[] ExecuteCall(String sql, String[] outputNames) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				CallableStatement stmt = conn.prepareCall(sql);
				) {
			for(int i = 0 ; i < outputNames.length ; i ++ ) {
				stmt.registerOutParameter(outputNames[i], Types.INTEGER);
			}
			boolean b = stmt.execute();
			if(b) {
				Object[] outputInfo = new Object[outputNames.length];
				for(int i = 0 ; i < outputNames.length ; i ++ ) {
					outputInfo[i] = stmt.getObject(outputNames[i]);
				}				
				ResultSet rs = stmt.getResultSet();
				ArrayList<DataRow> outputList = new ArrayList<DataRow>();
				int numberOfCols = rs.getMetaData().getColumnCount();
				ArrayList<String> currentRowData = new ArrayList<String>();
				while(rs.next()) {
					currentRowData.clear();
					for(int i = 1; i <= numberOfCols; i++) {
						currentRowData.add(rs.getString(i));
					}
					outputList.add(new StringRow(currentRowData));
				}
				return (DataRow[]) outputList.toArray();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String[] ExecuteSingleColumn(String sql) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			ArrayList<String> outputList = new ArrayList<String>();
			String s;
			while(rs.next()) {
				s = rs.getString(1);
				//System.out.println(s);
				outputList.add(s);
			}
			return outputList.toArray(new String[outputList.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String ExecuteSingleCell(String sql) {
		// Open a connection
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public DataRow[] Execute(String sql) {
		//	    	  ResultSetMetaData rsmd = rs.getMetaData();
		//rsmd.getColumnName(1);
		// TODO Auto-generated method stub
		return null;
	}
}
