package reserved.pl.testdata;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	@DataProvider(name = "loginTest")
	public static Object[][] createUserData() {
		return new Object[][] { { "ta_reserved_prod_pl@mail.com", "qweasd12", "JAKUB" } };
	}
}
