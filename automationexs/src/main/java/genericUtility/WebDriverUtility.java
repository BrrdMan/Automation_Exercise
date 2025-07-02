package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Devayan
 */
public class WebDriverUtility {

	public WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method maximizes the window
	 * 
	 * @param driver
	 */
	public void maximize() {
		driver.manage().window().fullscreen();
	}

	/**
	 * This method provides implicit wait
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void implicitWait(int timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	/**
	 * This method performs right click operation
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void rightClick(WebElement webElement) {
		Actions act = new Actions(driver);
		act.contextClick(webElement).perform();
	}

	/**
	 * This method performs double click operation
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void doubleClick(WebElement webElement) {
		Actions act = new Actions(driver);
		act.doubleClick(webElement).perform();
	}

	/**
	 * This method performs click and hold operation
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void clickAndHold(WebElement webElement) {
		Actions act = new Actions(driver);
		act.clickAndHold(webElement).perform();
	}

	/**
	 * This method performs mouse hover operation
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void mouseHover(WebElement webElement) {
		Actions act = new Actions(driver);
		act.moveToElement(webElement).perform();
	}

	/**
	 * This method performs scrolling operation
	 * 
	 * @param driver
	 * @param webElement
	 */
	public void scrollTo(WebElement webElement) {
		Actions act = new Actions(driver);
		act.scrollToElement(webElement).perform();
	}

	/**
	 * This method performs drag and drop operation
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	/**
	 * This method takes a screenshot of webpage
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public void takeSnapshotOfPage() throws IOException {
		JavaUtility jUtil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/[WEBPAGE] " + jUtil.getTimestamp() + ".png");
		FileHandler.copy(temp, dest);
	}

	/**
	 * This method takes a screenshot of web element
	 * 
	 * @param webElement
	 * @throws IOException
	 */
	public void takeSnapshotOfElement(WebElement webElement) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		File temp = webElement.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/[ELEMENT] " + jUtil.getTimestamp() + ".png");
		FileHandler.copy(temp, dest);
	}

	/**
	 * This method utilizes javascript to scroll to element
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void jsScroll(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + x + ", " + y + ")");
	}

	/**
	 * This method is used to switch control to alert popup
	 * 
	 * @return
	 */
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	/**
	 * This method is used to switch control to another window
	 * 
	 * @param expUrl
	 */
	public void switchToWindow(String expUrl) {
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			if (driver.getCurrentUrl().contains(expUrl))
				break;
		}
	}

	/**
	 * This method is used to select a dropdown option based on index value
	 * 
	 * @param webElement
	 * @param index
	 */
	public void selectOptionByIndex(WebElement webElement, int index) {
		new Select(webElement).selectByIndex(index);
	}

	/**
	 * This method is used to select a dropdown option based on value attribute
	 * 
	 * @param webElement
	 * @param val
	 */
	public void selectOptionByValue(WebElement webElement, String val) {
		new Select(webElement).selectByValue(val);
	}

	/**
	 * This method is used to select a dropdown option based on visible text
	 * 
	 * @param webElement
	 * @param vText
	 */
	public void selectOptionByText(WebElement webElement, String vText) {
		new Select(webElement).selectByVisibleText(vText);
	}

	/**
	 * This method is used to return all options present in the dropdown
	 * 
	 * @param webElement
	 * @return
	 */
	public List<WebElement> getAllOptions(WebElement webElement) {
		return new Select(webElement).getOptions();
	}

	/**
	 * This method is used to switch to frame based on index
	 * 
	 * @param index
	 */
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frame based on id/name
	 * 
	 * @param idOrName
	 */
	public void switchToFrameByIdOrName(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * This method is used to switch to frame based on the element
	 * 
	 * @param webElement
	 */
	public void switchToFrameByWebElement(WebElement webElement) {
		driver.switchTo().frame(webElement);
	}

	/**
	 * This method is used to switch control to parent frame
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
}
