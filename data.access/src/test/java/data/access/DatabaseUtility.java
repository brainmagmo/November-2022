package data.access;
import java.sql.*;


public class DatabaseUtility implements DatabaseAccessor {

   static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT staff_id, first_name, last_name FROM staff";
   
   public void start() {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
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


	public String[] ExecuteSingleColumn(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ExecuteSingleCell(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataRow[] Execute(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
