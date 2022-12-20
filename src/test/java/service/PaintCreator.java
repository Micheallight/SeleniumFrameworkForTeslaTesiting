package service;

import model.Paint;

public class PaintCreator {
	public static final String TESTDATA_PAINT_NAME = "testdata.paint.name";
	public static final String TESTDATA_PAINT_PRICE = "testdata.paint.price";

	public static Paint createPaintWithCredentialsFromProperty() {
		return new Paint(
				TestDataReader.getTestData(TESTDATA_PAINT_NAME),
				TestDataReader.getTestData(TESTDATA_PAINT_PRICE)
		);
	}

}
