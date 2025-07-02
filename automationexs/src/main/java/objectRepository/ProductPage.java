package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(id = "search_product")
	private WebElement searchField;

	@FindBy(id = "submit_search")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@class='product-image-wrapper']")
	private List<WebElement> productListings;

	@FindBy(xpath = "//a[text()='View Product']")
	private List<WebElement> viewProductLink;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public List<WebElement> getProductListings() {
		return productListings;
	}

	public List<WebElement> getViewProductLink() {
		return viewProductLink;
	}

}
