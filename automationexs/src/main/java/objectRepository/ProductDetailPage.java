package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

	@FindBy(xpath = "//label[contains(text(),'Quantity')]/../..//h2")
	private WebElement prodName;

	@FindBy(xpath = "(//label[contains(text(),'Quantity')]/../..//p)[1]")
	private WebElement prodCategory;

	@FindBy(xpath = "//label[contains(text(),'Quantity')]/../..//span[contains(text(),'Rs')]")
	private WebElement prodPrice;

	@FindBy(xpath = "(//label[contains(text(),'Quantity')]/../..//p)[2]")
	private WebElement prodAvailability;

	@FindBy(xpath = "(//label[contains(text(),'Quantity')]/../..//p)[3]")
	private WebElement prodCondition;

	@FindBy(xpath = "(//label[contains(text(),'Quantity')]/../..//p)[4]")
	private WebElement prodBrand;

	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getProdCategory() {
		return prodCategory;
	}

	public WebElement getProdPrice() {
		return prodPrice;
	}

	public WebElement getProdAvailability() {
		return prodAvailability;
	}

	public WebElement getProdCondition() {
		return prodCondition;
	}

	public WebElement getProdBrand() {
		return prodBrand;
	}

}
