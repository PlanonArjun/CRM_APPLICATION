package com.vt.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.WebDriverUtility;

public class CampaigingPage extends WebDriverUtility {

	@FindBy(css = "[alt='Create Campaign...']")
	private WebElement createCampaignLookUpImg;

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement campaignPageHederText;

	@FindBy(className = "lvtHeaderText")
	private WebElement campaigningFormHeaderText;

	@FindBy(name = "campaignname")
	private WebElement campaignNameEdt;

	@FindBy(name = "campaigntype")
	private WebElement campaignTypeDrp;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdCampaignFormHeaderTitle;

	// initialization
	public CampaigingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateCampaignLookUpImg() {
		return createCampaignLookUpImg;
	}

	public WebElement getCampaigningFormHeaderText() {
		return campaigningFormHeaderText;
	}

	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	public WebElement getCampaignTypeDrp() {
		return campaignTypeDrp;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCreatedCampaignFormHeaderTitle() {
		return createdCampaignFormHeaderTitle;
	}

	public WebElement getCampaignPageHederText() {
		return campaignPageHederText;
	}

	// Business Library
	public void clickOnCampaignLookUpImage() {
		getCreateCampaignLookUpImg().click();
	}

	public String getCampaigningFormHeader() {
		return getCampaigningFormHeaderText().getText();
	}

	public void createCampaign(WebDriver driver, String campaignName, String campaignType, String closeDate) {
		getCampaignNameEdt().sendKeys(campaignName);
		handleDropDown(getCampaignTypeDrp(), campaignType);
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getSaveBtn().click();
	}

	public void createNewCampaign(WebDriver driver, String campaignName, String closeDate) {
		getCampaignNameEdt().sendKeys(campaignName);
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getSaveBtn().click();
	}

	public String getCreatedFormCampaignHeader() {
		return getCreatedCampaignFormHeaderTitle().getText();
	}

	public String getCreatedPageCampaignHeader() {
		return getCampaignPageHederText().getText();
	}

}
