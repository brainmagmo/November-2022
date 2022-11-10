package data.access;

import org.testng.Assert;
import org.testng.annotations.*;

public class JdbcTests {
	
	private DatabaseAccessor accessor;

	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility();
	}
	
	@Test
	public void canStart() {
		accessor.start();
	}

	@Test
	public void canAccessDataBase (){
		var result = ExecuteQuery("sql");
		Assert.assertNotNull(result);
	}

	private DataRow[] ExecuteQuery(String sql) {
		return this.accessor.Execute(sql);
	}
}
