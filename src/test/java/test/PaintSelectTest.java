package test;

import model.Paint;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DesignOverviewPage;
import service.PaintCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PaintSelectTest extends CommonConditions {
	private final String WHITE_PAINT_NAME = TestDataReader.getTestData("testdata.paint.name.white");
	private final String WHITE_PAINT_PRICE = TestDataReader.getTestData("testdata.paint.price.white");
	private final String SILVER_PAINT_NAME = TestDataReader.getTestData("testdata.paint.name.silver");
	private final String SILVER_PAINT_PRICE = TestDataReader.getTestData("testdata.paint.price.silver");
	private final String BLUE_PAINT_NAME = TestDataReader.getTestData("testdata.paint.name.blue");
	private final String BLUE_PAINT_PRICE = TestDataReader.getTestData("testdata.paint.price.blue");
	private final String BLACK_PAINT_NAME = TestDataReader.getTestData("testdata.paint.name.black");
	private final String BLACK_PAINT_PRICE = TestDataReader.getTestData("testdata.paint.price.black");
	private final String RED_PAINT_NAME = TestDataReader.getTestData("testdata.paint.name.red");
	private final String RED_PAINT_PRICE = TestDataReader.getTestData("testdata.paint.price.red");

	@Test
	public void selectWhitePaintTest() {
		String currentPrice = new DesignOverviewPage(driver)
				.openPage()
				.scrollDownPage()
				.getCurrentPaintPrice();
		assertThat(currentPrice, is(equalTo(WHITE_PAINT_PRICE)));
	}

	@Test
	public void selectSilverPaintTest() {
		String currentPrice = new DesignOverviewPage(driver)
				.openPage()
				.scrollDownPage()
				.selectPaintByName(SILVER_PAINT_NAME)
				.getCurrentPaintPrice();
		assertThat(currentPrice, is(equalTo(SILVER_PAINT_PRICE)));
	}

	@Test
	public void selectBluePaintTest() {
		String currentPrice = new DesignOverviewPage(driver)
				.openPage()
				.scrollDownPage()
				.selectPaintByName(BLUE_PAINT_NAME)
				.getCurrentPaintPrice();
		assertThat(currentPrice, is(equalTo(BLUE_PAINT_PRICE)));
	}

	@Test
	public void selectBlackPaintTest() {
		String currentPrice = new DesignOverviewPage(driver)
				.openPage()
				.scrollDownPage()
				.selectPaintByName(BLACK_PAINT_NAME)
				.getCurrentPaintPrice();
		assertThat(currentPrice, is(equalTo(BLACK_PAINT_PRICE)));
	}

	@Test
	public void selectRedPaintTest() {
		String currentPrice = new DesignOverviewPage(driver)
				.openPage()
				.scrollDownPage()
				.selectPaintByName(RED_PAINT_NAME)
				.getCurrentPaintPrice();
		assertThat(currentPrice, is(equalTo(RED_PAINT_PRICE)));
	}
}
