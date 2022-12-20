package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {
	protected WebDriver webDriver;
	public static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofMillis(8000);

	protected AbstractPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	protected abstract AbstractPage openPage() throws InterruptedException;
}