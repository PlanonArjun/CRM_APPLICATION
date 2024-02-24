package com.vt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	@FindBy(xpath = "//*[contains(@alt,'Create Organization...')]") // img[@alt='Create Organization...']
	private WebElement createOrgLookUpImg;

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//*[contains(@name, 'industry')]")
	private WebElement industryDropDwn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// @FindBy(xpath = "//*[contains(@class,'dvHeaderText')]")
	@FindBy(css = "[class='dvHeaderText']")
	private WebElement orgFromHeaderText;

	// initializations
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return industryDropDwn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void clickOnLeadLookUpImage() {
		getCreateOrgLookUpImg().click();
	}

	public WebElement getCreatedOrgHeaderText() {
		return orgFromHeaderText;
	}

	public void createOrganization(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();

	}

	public void createOrganizationWithIndustry(String orgname, String industryType) {
		getCreateOrgLookUpImg().click();
		orgNameEdt.sendKeys(orgname);
		handleDropDown(industryDropDwn, industryType);
		saveBtn.click();

	}

	public String getHeader() {
		return getCreatedOrgHeaderText().getText();
	}

}
