//import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class APITests {
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in/api";
	}
	
	@Test
	public void canRunTest() {
	}

	@Test
	public void canUseVar() {
		String test = "Trevor";
		var testOne = "Trevor";
		Assert.assertEquals(test, testOne);
	}
	
	@Test
	public void canInit() {
		APITool.initialize();
	}	
//	Using RestAssured ...
//	1. (GET single user) Write a test that verifies the email address for employee id 2 is 'janet.weaver@reqres.in' 
	@Test
	public void canGetAUser() {

		get("/users/2")
		.then()
			.body("data.id", equalTo(2))
		.and()
			.body("data.email", equalTo("janet.weaver@reqres.in"));
		
	}
//	2. (POST login - succesful) Write a test that verifies the token return value.
	@SuppressWarnings("unchecked")
	@Test
	public void canLogin() {
		
	    JSONObject requestBody = new JSONObject();
	    requestBody.put("email", "eve.holt@reqres.in");
	    requestBody.put("password", "cityslicka"); 
		
	    Response response = given()
	    		.header("Content-type", "application/json")
	    		.and()
	    		.body(requestBody.toString())
	    		.when()
	    		.post("/login")
	    		.then().extract().response(); 
	     
		Assert.assertNotNull(response.jsonPath().get("token"));
		Assert.assertNull(response.jsonPath().get("error"));
	}
//	3. (DELETE) 
//	a. Write a test that verifies the response code of 204. 
//	b. Lookup response code 204 and add it to your test as a comment.

//	4. (PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

//	5. (PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

//	6. (GET single user). Deserialize the user data into an object.

//	7. (GET list users). Deserialize the user data into a collection of objects.
}
