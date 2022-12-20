package test;

import org.testng.annotations.Test;
import page.DesignOverviewPage;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class EnterZipCodeTest extends CommonConditions {
	private final String ZIP_CODE = TestDataReader.getTestData("testdata.zipcode");

	@Test
	public void enterZipCode() {
		String enteredZipCode = new DesignOverviewPage(driver)
				.openPage()
				.callZipCodeEntryForm()
				.enterZipCode(ZIP_CODE)
				.confirmZipCode()
				.getEnteredZipCode();
		System.out.println(enteredZipCode);
		System.out.println(ZIP_CODE);
		assertThat(enteredZipCode, is(equalTo(ZIP_CODE)));
	}
}
