package vtigerLeadTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vt.annotation.FrameworkAnnotation;
import com.vt.enums.CategoryType;
import com.vt.listeners.ListenerClass;
import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.LeadPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.ExcelUtils;
import com.vt.utilities.RandomUtilsImpliments;

@Listeners(ListenerClass.class)
public class CreateLeadIndustryTest extends BaseClass {

	@Test(/*dataProvider = "getData",*/groups = "RegressionSuite")
	@FrameworkAnnotation(author = { "Amuthan", "Sachin" }, category = { CategoryType.REGRESSION })
	public void createLeadWithIndustry() {

		// Step 3: read all the required data
		String firstName = RandomUtilsImpliments.getFirstName();
		String lastName = RandomUtilsImpliments.getLastName();
		String company = RandomUtilsImpliments.getCompanyName();
		String industryType ="Engineering"; //can use data-provide for multipule data & run.

		// Step 4: Navigate to Leads Link
		HomePage hp = new HomePage(getDriver());
		hp.clickOnLeadsLink();

		// Step 5: Navigate to create Lead Look up image
		LeadPage lp = new LeadPage(getDriver());

		String leadPageHeader = lp.getLeadHeader();
		Assert.assertTrue(leadPageHeader.contains("Leads"));
		System.out.println("Lead Page Header Matched : " + leadPageHeader);

		lp.clickOnLeadLookUpImage();

		String createLeadPageHeader = lp.getCreateLeadPageHeader();
		Assert.assertTrue(createLeadPageHeader.contains("Creating New Lead"));
		System.out.println("Create Lead Page Header Matched : " + createLeadPageHeader);

		lp.createLeadIndustry(getDriver(), firstName, lastName, company ,industryType);

		// Step 7: Validate
		String leadNameHeader = lp.getLeadNameHeader();
		Assert.assertEquals(leadNameHeader, leadNameHeader);
		// Assert.assertTrue(leadNameHeader.contains(firstName + lastName));
		System.out.println("Lead Name Matched : " + leadNameHeader);
		// wUtil.takeScreenShot(driver, leadNameHeader);

	}
	
	/*
	 * @DataProvider(parallel =false ) 
	 * public Object[][]getData(){ return
	 * ExcelUtils.readMultipleData("IndustryType"); }
	 */

}
