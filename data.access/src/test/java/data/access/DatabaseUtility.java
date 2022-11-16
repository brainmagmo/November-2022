package data.access;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtility implements DatabaseAccessor {

	private String DB_URL;

	public DatabaseUtility(String DB_URL) {
		this.DB_URL = DB_URL;
	}

	public DataRow[] executeQuery(String sql) {

		try(Connection connection = DriverManager.getConnection(DB_URL);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {

			DataRow[] dataArray = null;
			try {
				dataArray = ResultSetToDataMatrix(resultSet);

			} catch (Exception e) {
				e.printStackTrace();
			} 
			resultSet.close();
			return dataArray;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String executeSingleCell(String sql) {

		DataRow[] data = executeQuery(sql);
		var stringData = data[0].getValueFromColumn(1);
		return stringData;
	}

	public String[] executeSingleColumn(String sql) {

		DataRow[] data = executeQuery(sql);
		var stringArray = new String[data.length];
		for(var i = 0 ; i < data.length ; i++) {
			stringArray[i] = data[i].getValueFromColumn(1);
		}
		return stringArray;

	}

	public DataRow[] executeCall(String call, String[] paramNames, Object[] inputs, int[] inputTypes, String[] outputNames, int[] outputTypes) {

		try (Connection connecction = DriverManager.getConnection(DB_URL);
				CallableStatement statement = connecction.prepareCall(call);) {

			for (int i = 0 ; i < inputs.length ; i++) {
				statement.setObject(paramNames[i], inputs[i], inputTypes[i]);
			}

			for (int i = 0 ; i < outputTypes.length ; i++) {
				statement.registerOutParameter(inputs.length+i+1, outputTypes[i]);
			}

			boolean hasExecuted = statement.execute();
			if(hasExecuted) {

				ResultSet resultSet = statement.getResultSet();

				DataRow[] dataMatrix = null;
				try {
					dataMatrix = ResultSetToDataMatrix(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return dataMatrix;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public static DataRow[] ResultSetToDataMatrix(ResultSet resultSet) {

		try {
			var metadata = resultSet.getMetaData();
			int numberOfCols = metadata.getColumnCount();
			var columnNames = new String[numberOfCols];
			for(var i = 0 ; i < numberOfCols ; i++) {
				columnNames[i] = metadata.getColumnName(i+1);
			}

			var outputList = new ArrayList<ResultDataRow>();

			while(resultSet.next()) {
				var row = new ResultDataRow();

				for(int i = 0; i < numberOfCols; i++) {
					row.setColumn(columnNames[i], resultSet.getString(i+1));
				}			

				outputList.add(row);
			}			
			return outputList.toArray(DataRow[]::new);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
