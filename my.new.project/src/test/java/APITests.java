//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.time.Instant;
import java.time.format.DateTimeParseException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojo.*;

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
	
/*/	1. (GET single user) Write a test that verifies the email address 
 * for employee id 2 is 'janet.weaver@reqres.in' 
 */
	@Test
	public void canGetAUser() {

		get("/users/2")
		.then()
			.body("data.id", equalTo(2))
		.and()
			.body("data.email", equalTo("janet.weaver@reqres.in"));
		
	}
/*/	2. (POST login - succesful) Write a test that verifies the token return value.*/
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
	     
		Assert.assertNotNull(response.jsonPath().get("token"), "API should return login token");
		Assert.assertNull(response.jsonPath().get("error"), "API should not return an error on successful login");
	}
	
/*/	3. (DELETE) 
//	a. Write a test that verifies the response code of 204. 
//	b. HTTP Status 204 (No Content) indicates that the server 
//	has successfully fulfilled the request and that there is 
//	no content to send in the response payload body.*/
	@Test
	public void canDelete() {
		var success = 204;
		
	    var response = given()
	    		.header("Content-type", "application/json")
	    		.when()
	    		.delete("/users/2")
	    		.then().extract().statusCode(); 
	    
		Assert.assertEquals(response, success, "API should delete user 2");
	}
	
/*/	4. (PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.
//  CANNOT WRITE TEST AS INSTRUCTED, NO USER WITH NAME MORPHEUS EXISTS IN DATABASE	*/
	@SuppressWarnings("unchecked")
	@Test
	public void canPatch() {
	    var now = Instant.now();
	    var isAfter = 1;
		
	    JSONObject requestBody = new JSONObject();
	    requestBody.put("name", "Morpheus2"); 
		
	    Response response = given()
	    		.header("Content-type", "application/json")
	    		.and()
	    		.body(requestBody.toString())
	    		.when()
	    		.patch("/users/2")
	    		.then().extract().response(); 

	    Instant update = null;
	    try {
	    	update = Instant.parse(response.jsonPath().get("updatedAt"));
	    } catch (DateTimeParseException e) {
	    	e.printStackTrace();
	    }
//	    System.out.println(response.asPrettyString());	    
//	    System.out.println("now: " + now);
//	    System.out.println("update: " + update);
//	    System.out.println("compare: " +update.compareTo(now));
	    Assert.assertNotNull(update, "patch should return update");
	    Assert.assertEquals(update.compareTo(now), isAfter, "Update should take place and return time after init");
	}
/*/	5. (PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. 
 * Ensure that UpdatedAt timestamp is updated and that the name was updated.
 */
	@SuppressWarnings("unchecked")
	@Test
	public void canPut() {
	    var now = Instant.now();
	    var isAfter = 1;
		
	    JSONObject requestBody = new JSONObject();
	    requestBody.put("name", "Morpheus2"); 
		
	    Response response = given()
	    		.header("Content-type", "application/json")
	    		.and()
	    		.body(requestBody.toString())
	    		.when()
	    		.put("/users/2")
	    		.then().extract().response(); 

	    Instant update = null;
	    try {
	    	update = Instant.parse(response.jsonPath().get("updatedAt"));
	    } catch (DateTimeParseException e) {
	    	e.printStackTrace();
	    }
	    Assert.assertNotNull(update, "patch should return update");
	    Assert.assertEquals(update.compareTo(now), isAfter, "Update should take place and return time after init");
	}
/*/	6. (GET single user). Deserialize the user data into an object.*/
	@Test
	public void canDeserializeAUser() {

		Data user = get("/users/2").as(Root.class).getData();
		Assert.assertEquals(user.getId(), 2);
		Assert.assertEquals(user.getEmail(), "janet.weaver@reqres.in");
		
	}
/*/	7. (GET list users). Deserialize the user data into a collection of objects.*/
}
