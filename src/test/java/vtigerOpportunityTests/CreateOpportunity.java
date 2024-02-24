package vtigerOpportunityTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vt.objectRepository.CampaigingPage;
import com.vt.objectRepository.ContactsPage;
import com.vt.objectRepository.HomePage;
import com.vt.objectRepository.OpportunityPage;
import com.vt.utilities.BaseClass;
import com.vt.utilities.RandomUtilsImpliments;

public class CreateOpportunity extends BaseClass {

	@Test
	public void createOpportunityWithContactTest() {

		String opportunityName = RandomUtilsImpliments.generateOpportunityName();
		String campaingName = RandomUtilsImpliments.generateCampaignName();
		String description = RandomUtilsImpliments.generateDescription();

		// * For date we have to pass number of days on
		// getOpportunityCloseDate(7)
		String closeDate = RandomUtilsImpliments.getOpportunityCloseDate(7);

		String firstName = RandomUtilsImpliments.getFirstName();
		String lastname = RandomUtilsImpliments.getLastName();

		HomePage hp = new HomePage(driver);
		// Click on Contact Link & Create on Contact
		hp.clickOnContactsLink();
		ContactsPage cop = new ContactsPage(driver);
		cop.clickOnCreateContactLookupImage();
		cop.createContact(driver, firstName, lastname);

		String contactHeader = cop.getContactFormHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(lastname));
		System.out.println("Contact Header Matched : " + lastname);

		// Navigate to Campaignlink and Create Campaign
		hp.clickOnCampaignsLink(driver);

		CampaigingPage cp = new CampaigingPage(driver);
		cp.clickOnCampaignLookUpImage();
		System.out.println("Click on Create Campainging image look up");
		cp.createNewCampaign(driver, campaingName, closeDate);
		System.out.println("Creating Campainging with Required Data");

		String createdCapaiginTitel = cp.getCreatedFormCampaignHeader();
		Assert.assertTrue(createdCapaiginTitel.contains(campaingName));
		System.out.println("Creating Campainging Name & Given Name is Same");

		// Navigate to Opportunity link and Create Opportunity
		hp.clickOnOpportunitiesLink();
		System.out.println("Navigate to Opportunities Link & Click on Opportunities.");

		OpportunityPage opp = new OpportunityPage(driver);

		opp.clickOnOpportunityLookUpImage();
		System.out.println("Click on Opportunity image look up");
		String OpportunityFormTitel = opp.getOpportunitiesPageHeader();
		Assert.assertTrue(OpportunityFormTitel.contains(OpportunityFormTitel));
		System.out.println("Click on the Opportunity form to Create Opportunity");

		try {
			String relatedToDrp = "Contacts";// Manuly passing the data we can pass from dropdown.
			opp.createOpportunityFullDetails(driver, opportunityName, lastname, campaingName, description, closeDate,
					relatedToDrp);
			System.out.println("Create Opportunity with Required data");
			String CretedOpportunity = opp.getCreatedFormOpportunityHeader();
			Assert.assertTrue(CretedOpportunity.contains(opportunityName));
			System.out.println("Creating Opportunity Name & Given Name is Same");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().getMessage();

		}
	}
}
