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
			+ "WHERE title = 'Alien Center'"
			;
	//`film_in_stock`(IN p_film_id INT, IN p_store_id INT, OUT p_film_count INT)
	static final String CALL = ""
			+ "{CALL sakila.film_in_stock(? , ? , ?)}"
			;

	public static DataRow[] ExecuteCall(
			String call, 
			int[] inputTypes, Object[] inputs,
			int[] outputTypes, String[] outputNames
			) {

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			CallableStatement stmt = conn.prepareCall(call);
			for (int i = 1 ; i <= inputTypes.length ; i++) {
				stmt.setObject(i, inputTypes[i-1]);
			}
			for (int i = 1 ; i <= outputTypes.length ; i++) {
				stmt.registerOutParameter(i+inputTypes.length, outputTypes[i-1]);
			}
			boolean b = stmt.execute();
			System.out.println("b: " + b);
			if(b) {
				Object[] outputInfo = new Object[outputNames.length];
				for (int i = 1 ; i <= outputNames.length ; i++) {
					outputInfo[i-1] = stmt.getInt(outputNames[i-1]);
				}
				ResultSet rs = stmt.getResultSet();
				int numberOfCols = rs.getMetaData().getColumnCount();
				System.out.println("cols: " + numberOfCols);
				String[] currentRowData = new String[numberOfCols];
				ArrayList<DataRow> outputList = new ArrayList<DataRow>();
				while(rs.next()) {// -> false??????????
					System.out.println("next");
					for(int i = 1; i <= numberOfCols; i++) {
						var s = rs.getString(i);
						System.out.println(i + " " + s);
						currentRowData[i-1] = rs.getString(i);
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
		/*
		 *(
			String call, 
			int[] inputTypes, Object[] inputs,
			String[] outputNames, int[] outputTypes
			)
		 */
		DatabaseAccessor db = new DatabaseUtility();
		int filmID = Integer.valueOf(
				db.ExecuteSingleCell(SQL));

		Object[] inputs = {filmID, storeID};
		int[] inTypes = {Types.INTEGER, Types.INTEGER};
		String[] outNames = {"p_film_count"};
		int[] outTypes = {Types.INTEGER};
		DataRow[] data = ExecuteCall(CALL, inTypes, inputs, outTypes, outNames);
		String[] inventoryIDs = new String[data.length];
		for(int i = 0 ; i < data.length ; i++) {
			inventoryIDs[i] = data[i].getData()[0];
		}
		return inventoryIDs;
	}

	public static void main(String[] args) {
		String[] results = getInventoryIds("Alien Center", 2);
		for(var result:results) {
			System.out.println(result);
		}
	}
}
