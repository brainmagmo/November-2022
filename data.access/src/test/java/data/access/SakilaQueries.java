package data.access;

public class SakilaQueries {

	private DatabaseAccessor db;

	public SakilaQueries(DatabaseAccessor accessor) {
		this.db = accessor;
	}

	public String getHighestPayment() {
		String sql = "SELECT MAX(p.amount) AS 'MaxAmount'"
				+ " FROM sakila.payment p;"
				;
		return db.ExecuteSingleCell(sql);
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
		return db.ExecuteSingleCell(sql);
	}

	public String[] getInventoryIds(String film, int storeID) {
		String sql = ""

				+ "{call sakila.film_in_stock("
				+ "(SELECT film_id"
				+ " FROM sakila.film"
				+ " WHERE title = '" 
				+ film 
				+ "'), " 
				+ storeID 
				+ ", @inventoryids)"
				+ "}"
				;
		String[] outNames = {"p_film_count"};
		DataRow[] dra = db.ExecuteCall(sql, outNames);
		String[] sa = new String[dra.length];
		for(int i = 0 ; i < dra.length ; i++) {
			sa[i] = dra[i].getData()[0];
		}
		return sa;
	}

	public String[] getCities() {
		var QUERY = "select city from sakila.city order by city desc limit 10;";
		return db.ExecuteSingleColumn(QUERY);
	}



}
