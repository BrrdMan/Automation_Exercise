package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(partialLinkText = "Home")
	private WebElement homeLink;

	@FindBy(partialLinkText = "Products")
	private WebElement productsLink;

	@FindBy(partialLinkText = "Cart")
	private WebElement cartLink;

	@FindBy(partialLinkText = "Test Cases")
	private WebElement testCasesLink;

	@FindBy(partialLinkText = "Contact us")
	private WebElement contactUsLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getTestCasesLink() {
		return testCasesLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

}
