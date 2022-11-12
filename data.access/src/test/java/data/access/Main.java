package data.access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class Main {

	//private DatabaseAccessor db = new DatabaseUtility();
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
	static final String USER = "root";
	static final String PASS = "password";
	static final String SQL = 	""
			+ "SELECT film_id "
			+ "FROM sakila.film "
			+ "WHERE title = '"
			;
	//`film_in_stock`(IN p_film_id INT, IN p_store_id INT, OUT p_film_count INT)
	static final String CALL = ""
			+ "{CALL sakila.film_in_stock(? , ? , ?)}"
			;
	static final int STORE = 2;

	public static DataRow[] ExecuteCall(
			String call, 
			String[] paramNames, Object[] inputs, int[] inputTypes, 
			int[] outputTypes, String[] outputNames 
			) {

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			CallableStatement stmt = conn.prepareCall(call);
			for (int i = 0 ; i < inputs.length ; i++) {
				stmt.setObject(paramNames[i], inputs[i], inputTypes[i]);
				//stmt.setObject(i, inputs[i-1]);
			}
			for (int i = 1 ; i <= outputTypes.length ; i++) {
				stmt.registerOutParameter(i+inputs.length, outputTypes[i-1]);
			}
			boolean b = stmt.execute();
			System.out.println("b: " + b);
			if(b) {
				ResultSet rs = stmt.getResultSet();
				int numberOfCols = rs.getMetaData().getColumnCount();
				System.out.println("cols: " + numberOfCols);
				ArrayList<DataRow> outputList = new ArrayList<DataRow>();
				while(rs.next()) {// -> false??????????
					System.out.println("next");
					String[] currentRowData = new String[numberOfCols];
					for(int i = 0; i < numberOfCols; i++) {
						var s = rs.getString(i+1);
						System.out.println(i + " " + s);
						currentRowData[i] = s;
					}
					outputList.add(new StringRow(currentRowData));
				}
				return outputList.toArray(new DataRow[outputList.size()]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public static String[] getInventoryIds(String film, int storeID) {

		DatabaseAccessor db = new DatabaseUtility();
		int filmID = Integer.valueOf(
				db.ExecuteSingleCell(SQL + film + "'"));
		String[] params = {"p_film_id", "p_store_id"};
		Object[] inputs = {filmID, storeID};
		int[] inTypes = {Types.INTEGER, Types.INTEGER};
		String[] outNames = {"p_film_count"};
		int[] outTypes = {Types.INTEGER};
		DataRow[] data = ExecuteCall(CALL, params, inputs, inTypes, outTypes, outNames);
		String[] inventoryIDs = new String[data.length];
		for(int i = 0 ; i < data.length ; i++) {
			inventoryIDs[i] = data[i].getData()[0];
		}
		return inventoryIDs;
	}

	public static void main(String[] args) {
//		DatabaseAccessor db = new DatabaseUtility();
//		int filmID = Integer.valueOf(
//				db.ExecuteSingleCell(SQL));
		String[] results = getInventoryIds("Alien Center", 2);
		for (var r : results) { System.out.println(r); }
//		try {
//			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			CallableStatement stmt = conn.prepareCall("{CALL sakila.film_in_stock(? , ? , ?)}");
//
//			stmt.setInt(1, filmID);
//			stmt.setInt(2, STORE);
//
//			stmt.registerOutParameter(3, Types.INTEGER);
//
//			boolean b = stmt.execute();
//			System.out.println("b: " + b);
//			
//			if(b) {
//				ResultSet rs = stmt.getResultSet();
//				int numberOfCols = rs.getMetaData().getColumnCount();
//				System.out.println("cols: " + numberOfCols);
//				
//				while(rs.next()) {// -> false??????????
//					System.out.println("next");
//					for(int i = 1; i <= numberOfCols; i++) {
//						var s = rs.getString(i);
//						System.out.println(i + " " + s);
//					}
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
		
	}
}
