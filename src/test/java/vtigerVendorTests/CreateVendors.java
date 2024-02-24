package vtigerVendorTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.VendorsPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

public class CreateVendors extends BaseClass {

	@Test
	public void createVendorsTest() {

		Map<String, String> vendorInfo = new HashMap<>();
		vendorInfo.put("vendorName", RandomUtilsImpliments.getCompanyName());
		vendorInfo.put("email", RandomUtilsImpliments.generateEmail());

		// We can use data provide to user all dropdown value.
		vendorInfo.put("gLAccount", "304-Sales-Software-Support");

		vendorInfo.put("category", RandomUtilsImpliments.generatorCategory());
		vendorInfo.put("phoneNumber", RandomUtilsImpliments.generateMobileNumber());
		vendorInfo.put("webSite", RandomUtilsImpliments.generateWebsite());
		vendorInfo.put("address", RandomUtilsImpliments.generateAddress());
		vendorInfo.put("description", RandomUtilsImpliments.generateDescription());

		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLink(driver);

		VendorsPage vp = new VendorsPage(driver);

		vp.getVendorsPageHeader();
		String vendorsPageHeader = vp.getVendorsPageHeader();
		Assert.assertTrue(vendorsPageHeader.contains(vendorsPageHeader));
		System.out.println("Vendors Page : " + vendorsPageHeader);

		vp.clickOnVendorsookUpImage();

		vp.createVendor(driver, vendorInfo);
		String creadedVendoreTitiel = vp.getVendorsPageHeader();
		Assert.assertTrue(creadedVendoreTitiel.contains(creadedVendoreTitiel));
		System.out.println("Created Vendors Page : " + creadedVendoreTitiel);

	}

}
