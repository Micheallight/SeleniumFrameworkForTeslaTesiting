package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaitUtils;

import java.time.Duration;
import java.util.List;

public class DesignOverviewPage extends AbstractPage {
	private static final Integer STAND_TIME_OF_WAITING = 3000;

	private static final String DESIGN_PAGE_URL = "https://www.tesla.com/model3/design#overview";
	private static final String DESIGN_PAGE_NULL_BY_URL = "https://www.tesla.com/null_BY/model3/design#overview";

	private static final String PURCHASE_PRICE_BUTTON_XPATH = "//button[@id='purchase_price']";
	private static final String POTENTIAL_SAVINGS_BUTTON_XPATH = "//button[@id='potential_savings']";

	private static final String MODEL_3_PRICE_XPATH = "//div[@class='trim-title-container']/span/p";

	private static final String ENTER_ZIP_CODE_XPATH = "//span[@class='tds-link']";
	private static final String ZIP_CODE_INPUT_XPATH = "//input[@id='DeliveryPostalCode']";
	private static final String CONFIRM_BUTTON_XPATH = "//button[@class='tds-btn tds-btn tds-btn--primary tds-btn--large tds-btn--width-full']";
//	private static final String ENTERED_ZIP_CODE_XPATH = "//button[@class='modal-trigger tds-o-text_color--20 tds-link']"; // no styles
	private static final String ENTERED_ZIP_CODE_XPATH = "/descendant::button[contains(@class, 'modal-trigger') and contains(@class, 'tds-link')][2]";

	private static final String PAINT_BUTTON_XPATH = "//span[text()[contains(., 'Deep Blue Metallic')]]/../..";
	private static final String PART_OF_PAINT_BUTTON_XPATH_FIRST = "//span[text()[contains(., '";
	private static final String PART_OF_PAINT_BUTTON_XPATH_SECOND = "')]]/../..";
	private static final String PAINT_NAME_XPATH = "/descendant::div[@class='tds-flex-item tds-flex--auto tds-flex--justify-flex-end'][1]/p/span";
	private static final String PAINT_PRICE_XPATH = "/descendant::div[@class='tds-flex-item tds-flex--auto group-option--price'][1]/p/span";
	// /descendant::div[@class='tds-flex-item tds-flex--auto group-option--price'][1]/p/span

	//button[contains(@class, 'modal-trigger') and contains(@class, 'tds-link')]
	// /descendant::button[contains(@class, 'modal-trigger') and contains(@class, 'tds-link')][2]

	//span[text()[contains(., 'Deep Blue Metallic')]]/../..

	private static final String EXPECTED_TEXT_NEAR_ENTERED_ZIP_STRING = "//span[text()[contains(.,'See Early Delivery Options')]]";

	private static final String CONTROL_ELEMENT_FOR_LOADING_PAGE = "//button[@class='tds-site-nav-item tds-animate--backdrop tds-site-header-menu-link']";

	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING));

	@FindBy(xpath = PURCHASE_PRICE_BUTTON_XPATH)
	private WebElement purchasePriceButton;

	@FindBy(xpath = MODEL_3_PRICE_XPATH)
	private WebElement model3Price;

	@FindBy(xpath = ENTER_ZIP_CODE_XPATH)
	private WebElement enterZipCode;

	@FindBy(xpath = ZIP_CODE_INPUT_XPATH)
	private WebElement zipCodeInput;

	@FindBy(xpath = CONFIRM_BUTTON_XPATH)
	private WebElement confirmButton;

	@FindBy(xpath = ENTERED_ZIP_CODE_XPATH)
	private WebElement zipCodeButton;

	@FindBy(xpath = PAINT_BUTTON_XPATH)
	private WebElement paintButton;

	@FindBy(xpath = PAINT_NAME_XPATH)
	private WebElement paintName;

	@FindBy(xpath = PAINT_PRICE_XPATH)
	private WebElement paintPrice;

	public DesignOverviewPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDriver, this);
	}

	// +class/method | not duplications

	public String getPaintName() {
		paintButton.click();
		WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(PAINT_NAME_XPATH, webDriver);
		return paintName.getText();
	}

	public String getPaintPrice() {
		paintButton.click();
		WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(PAINT_PRICE_XPATH, webDriver);
		return paintPrice.getText();
	}

	public DesignOverviewPage scrollDownPage() {
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_PRICE_BUTTON_XPATH)));
//		webDriver.findElement(By.xpath(PURCHASE_PRICE_BUTTON_XPATH)).click();

		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PAINT_BUTTON_XPATH)));
//		webDriver.findElement(By.xpath(PAINT_BUTTON_XPATH)).click();
		return this;
	}

	public DesignOverviewPage selectPaintByName(String name) {
		String fullXpath = PART_OF_PAINT_BUTTON_XPATH_FIRST + name + PART_OF_PAINT_BUTTON_XPATH_SECOND;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fullXpath)));
		webDriver.findElement(By.xpath(fullXpath)).click();
		return this;
	}

	public String getCurrentPaintPrice() {
		return webDriver.findElement(By.xpath(PAINT_PRICE_XPATH)).getText();
	}




//	public List<WebElement> getPriceValues() { // not web elements
//		List<WebElement> listOfPriceValues = new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(MODEL_3_PRICE_XPATH)));
//
//		return listOfPriceValues;
//	}
//
//	public DesignOverviewPage switchToPurchasePrice() {
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_PRICE_BUTTON_XPATH)));
//		purchasePriceButton.click();
//
//		return this;
//	}
//
//	public DesignOverviewPage openZipCodeInputWindow() {
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTER_ZIP_CODE_XPATH)));
//		zipCodeButton.click();
//		return this;
//	}
//
//	public DesignOverviewPage enterZipCode(String zipCode) {
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ZIP_CODE_INPUT_XPATH)));
//		WebElement inputZipCode = new WebDriverWait(webDriver, Duration.ofMillis(3000))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ZIP_CODE_INPUT_XPATH)));
//		inputZipCode.clear();
//		inputZipCode.sendKeys(zipCode);
//		return this;
//	}
//
//	public DesignOverviewPage confirmZipCode() {
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.elementToBeClickable(By.xpath(CONFIRM_BUTTON_XPATH)));
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRM_BUTTON_XPATH)));
//		WebElement confirmButton = new WebDriverWait(webDriver, Duration.ofMillis(3000))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRM_BUTTON_XPATH)));
//		confirmButton.click();
//		return this;
//	}
//
//	public String getEnteredZipCode() {
//		new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPECTED_TEXT_NEAR_ENTERED_ZIP_STRING)));
//		WebElement enteredZipCode = new WebDriverWait(webDriver, Duration.ofMillis(STAND_TIME_OF_WAITING))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTERED_ZIP_CODE_XPATH)));
//		return enteredZipCode.getText();
//	}

	@Override
	public DesignOverviewPage openPage() {
		webDriver.get(DESIGN_PAGE_URL);
		if (!webDriver.getCurrentUrl().equals(DESIGN_PAGE_URL)) {
			webDriver.get(DESIGN_PAGE_URL);
			if (!webDriver.getCurrentUrl().equals(DESIGN_PAGE_URL)) {
				webDriver.get(DESIGN_PAGE_URL);
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POTENTIAL_SAVINGS_BUTTON_XPATH)));
		webDriver.findElement(By.xpath(POTENTIAL_SAVINGS_BUTTON_XPATH)).click();
		return this;
	}
}
