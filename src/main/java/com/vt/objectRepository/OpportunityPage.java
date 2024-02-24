package com.vt.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.RandomUtilsImpliments;
import com.vt.utilities.WebDriverUtility;

public class OpportunityPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunityLookUpImg;

	@FindBy(xpath = "//span[contains(text(), 'Creating New Opportunity')]")
	private WebElement opportunityFormHeader;

	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNameEdt;

	@FindBy(xpath = "//select[@id='related_to_type']")
	private WebElement relatedToDrp;

	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::Img[@title='Select']")
	private WebElement relatedToDrpValueLookUpImg;

	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;

	@FindBy(name = "search")
	private WebElement orgSearchBtn;

	@FindBy(xpath = "//select[@name='opportunity_type']")
	private WebElement opportunityTypeDrp;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDrp;

	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement assignedToDrp;

	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::Img[@title='Select']")
	private WebElement campaignSourceLookUpImg;

	@FindBy(name = "amount")
	private WebElement amount;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;

	@FindBy(name = "sales_stage")
	private WebElement salesStageDrp;

	@FindBy(xpath = "//textarea[@class='detailedViewTextBox']")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdOpportunityHeaderTitle;

	// initialization
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateOpportunityLookUpImg() {
		return createOpportunityLookUpImg;
	}

	public WebElement getOpportunityHeaderText() {
		return opportunityFormHeader;
	}

	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getRelatedToDrp() {
		return relatedToDrp;
	}

	public WebElement getRelatedToDrpValueLookUpImg() {
		return relatedToDrpValueLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}

	public WebElement getOpportunityTypeDrp() {
		return opportunityTypeDrp;
	}

	public WebElement getLeadSourceDrp() {
		return leadSourceDrp;
	}

	public WebElement getAssignedToDrp() {
		return assignedToDrp;
	}

	public WebElement getCampaignSourceLookUpImg() {
		return campaignSourceLookUpImg;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getSalesStageDrp() {
		return salesStageDrp;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOpportunityFormHeaderTitel() {
		return createdOpportunityHeaderTitle;
	}

	// Business library
	public void clickOnOpportunityLookUpImage() {
		getCreateOpportunityLookUpImg().click();
	}

	public String getOpportunitiesPageHeader() {
		return getOpportunityHeaderText().getText();
	}

	public void createOpportunityFullDetails(WebDriver driver, String opportunityName, String commonValue,
			String campaignsName, String description, String closeDate, String relatedDrp) {

		getOpportunityNameEdt().sendKeys(opportunityName);

		handleDropDown(getRelatedToDrp(), relatedDrp);

		if (relatedDrp.contentEquals("Accounts")) {
			getRelatedToDrpValueLookUpImg().click();
			switchToWindow(driver, "Accounts");
			orgSearchEdt.sendKeys(commonValue);// common elements so used same button
			orgSearchBtn.click();// common elements so used same button
			driver.findElement(By.xpath("//a[.='" + commonValue + "']")).click();
			switchToWindow(driver, "Potentials");// opportunity page.
		} else {
			getRelatedToDrpValueLookUpImg().click();
			switchToWindow(driver, "Contacts");
			orgSearchEdt.sendKeys(commonValue);// common elements so used same button
			orgSearchBtn.click();// common elements so used same button
			driver.findElement(By.xpath("//a[contains(., '" + commonValue + "')]")).click();
			switchToWindow(driver, "Potentials");// opportunity page.
		}

		/* I have Taken staic Value ,If require dynami value can use data Provider. */
		handleDropDown(getOpportunityTypeDrp(), "Existing Business");
		handleDropDown(getLeadSourceDrp(), "Cold Call");

		/* This will handle campaing dropdwon value */
		getCampaignSourceLookUpImg().click();
		switchToWindow(driver, "Campaigns");// campaigns
		orgSearchEdt.sendKeys(campaignsName);// common elements so used same button
		orgSearchBtn.click(); // common elements so used same button
		driver.findElement(By.xpath("//a[.='" + campaignsName + "']")).click();
		switchToWindow(driver, "Potentials");// opportunity page.

		getAmount().sendKeys(RandomUtilsImpliments.getPrice());
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getDescriptionEdt().sendKeys(description);

		getSaveBtn().click();

	}

	public void createOpportunityWithContactOrOrg(WebDriver driver, String opportunityName, String relatedDrp,
			String commonValue, String closeDate,String description) throws Exception {

		getOpportunityNameEdt().sendKeys(opportunityName);
		handleDropDown(getRelatedToDrp(), relatedDrp);

		if (relatedDrp.contentEquals("Accounts")) {
			getRelatedToDrpValueLookUpImg().click();
			switchToWindow(driver, "Accounts");
			orgSearchEdt.sendKeys(commonValue);// common elements so used same button
			orgSearchBtn.click();// common elements so used same button
			Thread.sleep(4000);

			driver.findElement(By.xpath("//a[.='" + commonValue + "']")).click();
			switchToWindow(driver, "Potentials");// opportunity page.
		} else {
			getRelatedToDrpValueLookUpImg().click();
			switchToWindow(driver, "Contacts");
			orgSearchEdt.sendKeys(commonValue);// common elements so used same button
			orgSearchBtn.click();// common elements so used same button
			driver.findElement(By.xpath("//a[contains(., '" + commonValue + "')]")).click();
			switchToWindow(driver, "Potentials");// opportunity page.
		}

		getAmount().sendKeys(RandomUtilsImpliments.getPrice());
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getDescriptionEdt().sendKeys(description);

		getSaveBtn().click();
	}

	public String getCreatedFormOpportunityHeader() {
		return getOpportunityFormHeaderTitel().getText();
	}

}