package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaitUtils;

import java.time.Duration;

public class DesignOverviewPage extends AbstractPage {
	private static final Integer STAND_TIME_OF_WAITING = 4000;

	private static final String DESIGN_PAGE_URL = "https://www.tesla.com/model3/design#overview";
	private static final String DESIGN_PAGE_NULL_BY_URL = "https://www.tesla.com/null_BY/model3/design#overview";

	private static final String PURCHASE_PRICE_BUTTON_XPATH = "//button[@id='purchase_price']";
	private static final String POTENTIAL_SAVINGS_BUTTON_XPATH = "//button[@id='potential_savings']";

	private static final String PART_OF_PRICE_BLOCK_XPATH_FIRST = "//div[@class='trim-title-container']/span/div/span[text()='";
	private static final String PART_OF_PRICE_BLOCK_XPATH_SECOND = "']/../../../span/p";

	private static final String MODEL_3_PRICE_XPATH = "//div[@class='trim-title-container']/span/p";

	private static final String ENTER_ZIP_CODE_XPATH = "//span[@class='tds-link']";
	private static final String ZIP_CODE_INPUT_XPATH = "//input[@id='DeliveryPostalCode']";
	private static final String CONFIRM_BUTTON_XPATH = "//button[@class='tds-btn tds-btn tds-btn--primary tds-btn--large tds-btn--width-full']";
	private static final String ENTERED_ZIP_CODE_XPATH = "//p[contains(@class, 'deliveryZipCode')]/span/div/button/span/span";

	private static final String PAINT_BUTTON_XPATH = "//span[text()[contains(., 'Deep Blue Metallic')]]/../..";
	private static final String PART_OF_PAINT_BUTTON_XPATH_FIRST = "//span[text()[contains(., '";
	private static final String PART_OF_PAINT_BUTTON_XPATH_SECOND = "')]]/../..";
	private static final String PAINT_NAME_XPATH = "/descendant::div[@class='tds-flex-item tds-flex--auto tds-flex--justify-flex-end'][1]/p/span";
	private static final String PAINT_PRICE_XPATH = "/descendant::div[@class='tds-flex-item tds-flex--auto group-option--price'][1]/p/span";

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
		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
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

	public DesignOverviewPage clickPurchasePriceButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_PRICE_BUTTON_XPATH)));
		webDriver.findElement(By.xpath(PURCHASE_PRICE_BUTTON_XPATH)).click();
		return this;
	}

	public String getPriceByModelName(String name) {
		String fullXpath = PART_OF_PRICE_BLOCK_XPATH_FIRST + name + PART_OF_PRICE_BLOCK_XPATH_SECOND;
		return webDriver.findElement(By.xpath(fullXpath)).getText();
	}

	public DesignOverviewPage callZipCodeEntryForm() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTER_ZIP_CODE_XPATH)));
		enterZipCode.click();
		return this;
	}

	public DesignOverviewPage enterZipCode(String zipCode) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONFIRM_BUTTON_XPATH)));
		zipCodeInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE)); //clear();
		zipCodeInput.sendKeys(zipCode);
		return this;
	}

	public DesignOverviewPage confirmZipCode() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONFIRM_BUTTON_XPATH)));
		confirmButton.click();
		return this;
	}

	public String getEnteredZipCode() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTERED_ZIP_CODE_XPATH)));
		return zipCodeButton.getText();
	}

	@Override
	public DesignOverviewPage openPage() {
		webDriver.get(DESIGN_PAGE_URL);
		webDriver.get(DESIGN_PAGE_URL);
		webDriver.get(DESIGN_PAGE_URL);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POTENTIAL_SAVINGS_BUTTON_XPATH)));
		webDriver.findElement(By.xpath(POTENTIAL_SAVINGS_BUTTON_XPATH)).click();
		return this;
	}
}
