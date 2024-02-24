package vtigerOrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vt.annotation.FrameworkAnnotation;
import com.vt.enums.CategoryType;
import com.vt.listeners.ListenerClass;
import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.OrganizationsPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

@Listeners(ListenerClass.class)
public class CreateOrganization extends BaseClass {

	@FrameworkAnnotation(author = { "Amuthan", "Sachin" }, category = { CategoryType.SMOKE })
	@Test
	public void createOrganizationTest() throws Exception {
		String organizationName = RandomUtilsImpliments.getCompanyName();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);

		op.clickOnLeadLookUpImage();
		op.createOrganization(organizationName);
		driver.navigate().refresh();

		String orgHeader = op.getHeader();
		Assert.assertTrue(orgHeader.contains(organizationName));
		System.out.println("Orgabization Name Matched : " + orgHeader);

		// hp.logOutOfApp(driver);
	}

}
