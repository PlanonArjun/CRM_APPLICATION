package vtigerOrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.OrganizationsPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.ExcelUtils;
import com.vt.utilities.RandomUtilsImpliments;

public class CreateMultipleOrganizationWithInd extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void createOrgWithIndTest(String industryType) throws Exception {

		String orgname = RandomUtilsImpliments.getCompanyName();

		/*
		 * String industryType = "Engineering";// can use data-provide for multipule
		 * data & run.
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);

		op.clickOnLeadLookUpImage();

		op.createOrganizationWithIndustry(orgname, industryType);
		driver.navigate().refresh();
		

		String orgHeader = op.getHeader();
		Assert.assertTrue(orgHeader.contains(orgname));

	}

	@DataProvider(parallel = false)
	public Object[][] getData() {
		return ExcelUtils.readMultipleData("IndustryType");
	}
}
