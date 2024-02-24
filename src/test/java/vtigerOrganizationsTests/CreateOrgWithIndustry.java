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
public class CreateOrgWithIndustry extends BaseClass {

	@FrameworkAnnotation(author = { "Amuthan", "Sachin" }, category = { CategoryType.REGRESSION })
	@Test
	public void createOrgWithIndTest() throws Exception {

		String orgname = RandomUtilsImpliments.getCompanyName();

		String industryType = "Engineering";// can use data-provide for multipule data & run.

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);

		op.clickOnLeadLookUpImage();

		op.createOrganizationWithIndustry(orgname, industryType);
		driver.navigate().refresh();

		String orgHeader = op.getHeader();
		Assert.assertTrue(orgHeader.contains(orgname));

	}

}
