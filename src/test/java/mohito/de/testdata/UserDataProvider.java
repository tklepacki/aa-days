package mohito.de.testdata;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	@DataProvider(name = "loginTest")
	public static Object[][] createUserData() {
		return new Object[][] { { "ta_mohito_prod_de@mail.com", "qweasd12" } };
	}
}
