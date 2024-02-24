package com.vt.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vt.utilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactImg;

	@FindBy(name = "firstname")
	private WebElement firstNameEdt;

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement firstNameDrp;

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactFormHeaderText;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement orgLookUpImg;

	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;

	@FindBy(name = "search")
	private WebElement orgSearchBtn;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateContactLookupImage() {
		createContactImg.click();
	}

	public void enterFirstName(String firstName) {
		firstNameEdt.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameEdt.sendKeys(lastName);
	}

	public void clickOnSaveButton() {
		saveBtn.click();
	}

	public WebElement getContactFormHeaderText() {
		return contactFormHeaderText;
	}

	public void selectSalutation(String salutation) {
		handleDropDown(firstNameDrp, salutation);
	}

	public void clickOnOrgLookupImage() {
		orgLookUpImg.click();
	}

	public void createContact(WebDriver driver, String firstname, String lastname) {
		handleDropDown(firstNameDrp, "Mr.");
		firstNameEdt.sendKeys(firstname);
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}

	public void createContactWithOrg(WebDriver driver, String firtname, String lastname, String orgname) {
		handleDropDown(firstNameDrp, "Mr.");
		firstNameEdt.sendKeys(firtname);
		lastNameEdt.sendKeys(lastname);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(orgname);
		orgSearchBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();

		switchToWindow(driver, "Contacts");
		saveBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public String getContactFormHeader() {
		return getContactFormHeaderText().getText();
	}
}
