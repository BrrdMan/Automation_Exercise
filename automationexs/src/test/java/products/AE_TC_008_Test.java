package products;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;
import objectRepository.ProductDetailPage;
import objectRepository.ProductPage;

@Listeners(ListenerUtility.class)
public class AE_TC_008_Test extends BaseClass {

	@Test
	public void verifyProducts() {
		HomePage hp = new HomePage(driver);

		hp.getProductsLink().click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products",
				"Product page is not displayed as expected");

		ProductPage prp = new ProductPage(driver);

		List<WebElement> productList = prp.getProductListings();
		List<WebElement> viewProduct = prp.getViewProductLink();

		ListIterator<WebElement> itpl = productList.listIterator();

		while (itpl.hasNext()) {
			WebElement product = itpl.next();
			Assert.assertEquals(product.isDisplayed(), true, "Product list is not displayed as expected");

		}

		viewProduct.get(0).click();

		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Product Details",
				"Product detail page is not displayed as expected");

		ProductDetailPage pdp = new ProductDetailPage(driver);
		Assert.assertEquals(pdp.getProdName().isDisplayed(), true);
		Assert.assertEquals(pdp.getProdCategory().isDisplayed(), true);
		Assert.assertEquals(pdp.getProdPrice().isDisplayed(), true);
		Assert.assertEquals(pdp.getProdAvailability().isDisplayed(), true);
		Assert.assertEquals(pdp.getProdCondition().isDisplayed(), true);
		Assert.assertEquals(pdp.getProdBrand().isDisplayed(), true);

	}

}
