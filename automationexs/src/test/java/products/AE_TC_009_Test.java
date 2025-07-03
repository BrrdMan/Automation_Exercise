package products;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;
import objectRepository.ProductPage;

@Listeners(ListenerUtility.class)
public class AE_TC_009_Test extends BaseClass {

	@Test
	public void searchProduct() throws EncryptedDocumentException, FileNotFoundException, IOException {
		HomePage hp = new HomePage(driver);

		hp.getProductsLink().click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products",
				"Product page is not displayed as expected");

		ProductPage prp = new ProductPage(driver);

		String searchQuery = eUtil.getStringValueFromExcel("Product Page", 1, 0).toLowerCase();
		prp.getSearchField().sendKeys(searchQuery);
		prp.getSearchBtn().click();

		Assert.assertEquals(prp.getSearchedProductheading().isDisplayed(), true,
				"Searched Products is not displayed as expected");

		List<WebElement> productName = prp.getProductNames();
		for (WebElement name : productName) {
			test.log(Status.INFO, name.getText());
			Assert.assertEquals(name.getText().toLowerCase().contains(searchQuery), true);

		}
	}

}
