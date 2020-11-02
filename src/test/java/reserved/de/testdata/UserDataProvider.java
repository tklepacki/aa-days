package reserved.de.testdata;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	@DataProvider(name = "loginTest")
	public static Object[][] createUserData() {
		return new Object[][] { { "ta_reserved_prod_de@mail.com", "qweasd12" } };
	}
}
