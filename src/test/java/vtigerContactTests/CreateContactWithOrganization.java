package vtigerContactTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vt.objectRepository.ContactsPage;
import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.OrganizationsPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

public class CreateContactWithOrganization extends BaseClass {

	@Test
	public void createContactWithOrganizationTest() {

		String orgname = RandomUtilsImpliments.getCompanyName();
		String industryType = "Engineering";// can use data-provide for multipule data & run.

		String firstName = RandomUtilsImpliments.getFirstName();
		String lastname = RandomUtilsImpliments.getLastName();

		/*
		 * First we are creating organization based on that we will add contact.
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);

		op.clickOnLeadLookUpImage();

		op.createOrganizationWithIndustry(orgname, industryType);
	
		// Contact creatation based on the organization
		hp.clickOnContactsLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImage();

		cp.createContactWithOrg(driver, firstName, lastname, orgname);

		System.out.println("Name : " + lastname);

		// Validate
		String contactHeader = cp.getContactFormHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(lastname));
		System.out.println("Contact Header Matched : " + lastname);
		// wUtil.takeScreenShot(driver, contactHeader);

	}

}
