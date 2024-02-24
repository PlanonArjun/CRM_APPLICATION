package vtigerContactTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vt.objectRepository.ContactsPage;
import com.vt.objectRepository.HomePage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

public class CreateContact extends BaseClass {

	@Test
	public void createContactTest() throws Exception {

		String firstName = RandomUtilsImpliments.getFirstName();
		String lastname = RandomUtilsImpliments.getLastName();

		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImage();

		cp.createContact(driver, firstName, lastname);

		System.out.println("Name : " + lastname);

		// Step 7: Validate

		String contactHeader = cp.getContactFormHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(lastname));
		System.out.println("Contact Header Matched : " + lastname);
		// wUtil.takeScreenShot(driver, contactHeader);

	}
}
