package com.vt.objectRepository;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.utilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement homepageHeader;

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(linkText = "Leads")
	private WebElement leadPageTitle;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(name = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(name = "Vendors")
	private WebElement vendorsLink;

	@FindAll({ @FindBy(linkText = "Sign Out"), @FindBy(xpath = "//*[text()='Sign Out']") })
	private WebElement signOutLink;

	@FindAll({ //@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']"),
			@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']/..") })
	private WebElement administratorImg;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomepageHeader() {
		return homepageHeader;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getLeadPageTitle() {
		return leadPageTitle;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public String getHomePageTitle() {
		return homepageHeader.getText();
	}

	public void clickOnLeadsLink() {
		leadsLink.click();
	}

	public void clickOnOrganizationsLink() {
		organizationsLink.click();
	}

	public void clickOnContactsLink() {
		contactsLink.click();
	}

	public void clickOnOpportunitiesLink() {
		opportunitiesLink.click();
	}

	public void clickOnProductsLink() {
		productsLink.click();
	}

	public void clickOnMoreLink() {
		moreLink.click();
	}

	public void clickOnCampaignsLink(WebDriver driver) {
		moreLink.click();
		waitForElementToBeVisisble(driver, campaignsLink);
		campaignsLink.click();
	}

	public void clickOnVendorsLink(WebDriver driver) {
		moreLink.click();
		waitForElementToBeVisisble(driver, vendorsLink);
		vendorsLink.click();
	}

	public void logOutOfApp(WebDriver driver) {
		mouseHoverAction(driver, administratorImg);

		Boolean actualElement = true;
		while (Boolean.TRUE.equals(actualElement)) {
			try {
				waitForElementToBeVisisble(driver, signOutLink);
				signOutLink.click();
				actualElement = false;
			} catch (NoSuchElementException | ElementNotInteractableException e) {
				actualElement = true;
			}
		}
	}
}
