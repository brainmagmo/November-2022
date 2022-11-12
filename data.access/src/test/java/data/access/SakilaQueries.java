package data.access;

import java.sql.Types;

public class SakilaQueries {

	private DatabaseAccessor db;
	
	static final String FILM_ID_SQL = 	""
			+ "SELECT film_id "
			+ "FROM sakila.film "
			+ "WHERE title = '"
			;
	static final String FIS_CALL = ""
			+ "{CALL sakila.film_in_stock(? , ? , ?)}"
			;
	static final String PAYMENT_SQL = ""
			+ "SELECT MAX(p.amount) AS 'MaxAmount'"
			+ " FROM sakila.payment p;"
			;
	static final String CITY_SQL = ""
			+ "SELECT city "
			+ "FROM sakila.city "
			+ "ORDER BY city DESC "
			+ "LIMIT 10;"
			;

	public SakilaQueries(DatabaseAccessor accessor) {
		this.db = accessor;
	}

	public String[] getCities() {
		return db.executeSingleColumn(CITY_SQL);
	}

	public String getHighestPayment() {
		return db.executeSingleCell(PAYMENT_SQL);
	}

	public String getFilmInfo(String actorName) {
		String[] names = actorName.split(" ");
		String sql = "SELECT film_info"
				+ " FROM sakila.actor_info"
				+ " WHERE first_name = '" 
				+ names[0] 
						+ "' AND last_name = '" 
						+ names[names.length-1]
								+ "';"
								;
		return db.executeSingleCell(sql);
	}

	public String[] getInventoryIds(String film, int storeID) {

		int filmID = Integer.valueOf(
				this.db.executeSingleCell(
						FILM_ID_SQL + film + "'")
					)
				;
		
		String[] params = {"p_film_id", "p_store_id"};
		Object[] inputs = {filmID, storeID};
		int[] inTypes = {Types.INTEGER, Types.INTEGER};
		String[] outNames = {"p_film_count"};
		int[] outTypes = {Types.INTEGER};
		
		DataRow[] data = db.executeCall(FIS_CALL, params, inputs, inTypes, outNames, outTypes);
		
		String[] inventoryIDs = new String[data.length];
		
		for(int i = 0 ; i < data.length ; i++) {
			inventoryIDs[i] = data[i].getData()[0];
		}
		
		return inventoryIDs;
	}
}
