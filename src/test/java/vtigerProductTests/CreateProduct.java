package vtigerProductTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vt.annotation.FrameworkAnnotation;
import com.vt.enums.CategoryType;
import com.vt.listeners.ListenerClass;
import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.ProductPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

@Listeners(ListenerClass.class)
public class CreateProduct extends BaseClass {

	@FrameworkAnnotation(author = { "Amuthan", "Sachin" }, category = { CategoryType.REGRESSION })
	@Test()
	public void createProductTest() {

		Map<String, String> productDetails = new HashMap<>();
		productDetails.put("productName", RandomUtilsImpliments.getProductName());
		productDetails.put("salesStartDate", RandomUtilsImpliments.getCheckinDate());
		productDetails.put("productCategory", "--None--"); //can use dataprovider for multipule value
		productDetails.put("unitPrice", RandomUtilsImpliments.getPrice());
		productDetails.put("commissionRate", RandomUtilsImpliments.getCommissionRate());

		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();

		ProductPage pp = new ProductPage(driver);
		String productPageHeader = pp.getProductPagetHeaderTitel();
		Assert.assertTrue(productPageHeader.contains(productPageHeader));

		pp.clickOnProductLookUpImage();

		pp.createProduct(driver, productDetails);
		String productFormTitel = pp.getCreatedProductHeaderTitel();
		Assert.assertTrue(productFormTitel.contains(productFormTitel));
		System.out.println("Created product Title mached : " + "" + productFormTitel);
	}

}
