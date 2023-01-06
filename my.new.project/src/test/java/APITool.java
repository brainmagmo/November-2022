import java.net.*;

public class APITool {
	
	public static void initialize() {
		try {
			URL targeturl = new URL("https://reqres.in/");
			HttpURLConnection con = (HttpURLConnection)targeturl.openConnection();
			con.setRequestMethod("GET");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static String getUserEmail(String string) {
		try {
			URL targeturl = new URL("https://reqres.in/");
			HttpURLConnection con = (HttpURLConnection)targeturl.openConnection();
			con.setRequestMethod("GET");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
