package test;

import org.testng.annotations.Test;
import page.DesignOverviewPage;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckBasicCarPriceTest extends CommonConditions {
	private static final String MODEL_3_NAME = TestDataReader.getTestData("testdata.model.basic");
	private static final String MODEL_3_PERFORMANCE_NAME = TestDataReader.getTestData("testdata.model.performance");

	private static final String EXPECTED_MODEL_3_PRICE_WITH_SAVINGS = TestDataReader.getTestData("testdata.price.with_savings.standard");
	private static final String EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITH_SAVINGS = TestDataReader.getTestData("testdata.price.with_savings.performance");
	private static final String EXPECTED_MODEL_3_PRICE_WITHOUT_SAVINGS = TestDataReader.getTestData("testdata.price.without_savings.standard");
	private static final String EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITHOUT_SAVINGS = TestDataReader.getTestData("testdata.price.without_savings.performance");

	@Test
	public void checkingModel3PriceWithSavings() {
		String model3PriceWithSavings = new DesignOverviewPage(driver)
				.openPage()
				.getPriceByModelName(MODEL_3_NAME);
		assertThat(model3PriceWithSavings, is(equalTo(EXPECTED_MODEL_3_PRICE_WITH_SAVINGS)));
	}

	@Test
	public void checkingModel3PerformancePriceWithSavings() {
		String model3PriceWithSavings = new DesignOverviewPage(driver)
				.openPage()
				.getPriceByModelName(MODEL_3_PERFORMANCE_NAME);
		assertThat(model3PriceWithSavings, is(equalTo(EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITH_SAVINGS)));
	}

	@Test
	public void checkingModel3PriceWithoutSavings() {
		String model3PriceWithSavings = new DesignOverviewPage(driver)
				.openPage()
				.clickPurchasePriceButton()
				.getPriceByModelName(MODEL_3_NAME);
		assertThat(model3PriceWithSavings, is(equalTo(EXPECTED_MODEL_3_PRICE_WITHOUT_SAVINGS)));
	}

	@Test
	public void checkingModel3PerformancePriceWithoutSavings() {
		String model3PriceWithSavings = new DesignOverviewPage(driver)
				.openPage()
				.clickPurchasePriceButton()
				.getPriceByModelName(MODEL_3_PERFORMANCE_NAME);
		assertThat(model3PriceWithSavings, is(equalTo(EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITHOUT_SAVINGS)));
	}
}
