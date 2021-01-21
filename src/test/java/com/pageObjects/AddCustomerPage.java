package com.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}

	// ======================Capture field================

	// capture the add button
	@FindBy(xpath = "//form/div/div[1]/a/i")
	@CacheLookup
	WebElement addbtn;

	// capture email filed
	@FindBy(name = "Email")
	@CacheLookup
	WebElement emailtxt;

	// Capture password filed
	@FindBy(id = "Password")
	@CacheLookup
	WebElement pwdtxt;

	// Capture first name field
	@FindBy(id = "FirstName")
	@CacheLookup
	WebElement fname;

	// Capture last name
	@FindBy(id = "LastName")
	@CacheLookup
	WebElement lname;

	// Capture male gender radio
	@FindBy(xpath = "//input[@id='Gender_Male']")
	@CacheLookup
	WebElement mgender;

	// Capture female gender radio
	@FindBy(xpath = "//input[@id='Gender_Female']")
	@CacheLookup
	WebElement fgender;

	// Capture DoB filed
	@FindBy(id = "DateOfBirth")
	@CacheLookup
	WebElement doB;

	// Capture Company name
	@FindBy(id = "Company")
	@CacheLookup
	WebElement companyname;

	// Capture the tax exempt button
	@FindBy(id = "IsTaxExempt")
	@CacheLookup
	WebElement taxexbtn;

	// Capture newsletter field
	@FindBy(xpath = "//input[@class='k-input k-readonly']")
	@CacheLookup
	WebElement newLetter;

	// Capture newsletter field name
	@FindBy(xpath = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[1]")
	@CacheLookup
	WebElement newLetteropt1;
	// Capture newsletter fieldname2
	@FindBy(xpath = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[2]")
	@CacheLookup
	WebElement newLetteropt2;

	// Customer role filed click
	@FindBys(@FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_listbox']/li"))
	@CacheLookup
	List<WebElement> customerolesclick;

	// Capture Customers role field
	@FindBy(xpath = "//*[@id='customer-info']/div[2]/div[1]/div[10]/div[2]/div/div[1]/div")
	@CacheLookup
	WebElement customeroles;

	// capture the the preselected customer roles button to clear

	@FindBy(xpath = "//*[@id='customer-info']/div[2]/div[1]/div[10]/div[2]/div/div[1]/div/span[1]")
	@CacheLookup
	WebElement clearcustomeroles;

	// Capture Manager vendor filed
	@FindBy(id = "VendorId")
	@CacheLookup
	WebElement managerVendor;

	public Select getManagerVendor() {
		return new Select(managerVendor);
	}

	// capture the active check box
	@FindBy(id = "Active")
	@CacheLookup
	WebElement activecheck;

	// Capture Admin comment filed
	@FindBy(id = "AdminComment")
	@CacheLookup
	WebElement addminComment;

	// Capture save button
	@FindBy(name = "save")
	@CacheLookup
	WebElement savebtn;

	// Capture save continue button
	@FindBy(name = "save-continue")
	@CacheLookup
	WebElement savecontinuebtn;

	// Capture logout button
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;

	// ===================Actions Methods===============

	// Click on the add button in customer section
	public void addNewCustomerBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(addbtn));
		wait.until(ExpectedConditions.elementToBeClickable(addbtn));
		addbtn.click();

	}

	// Sending email address
	public void sendEmailAddrs(String email) {

		emailtxt.clear();
		emailtxt.sendKeys(email);
	}

	// Sending password
	public void sendPassword(String pswd) {

		pwdtxt.clear();
		pwdtxt.sendKeys(pswd);
	}

	// Sending first name
	public void sendFName(String fsnmae) {
		fname.clear();
		fname.sendKeys(fsnmae);
	}

	// Sending first name
	public void sendLname(String lsnmae) {
		lname.clear();
		lname.sendKeys(lsnmae);
	}

	// Choosing gender type
	public void choosingGenderType(String gender) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(fgender));
		wait.until(ExpectedConditions.elementToBeClickable(fgender));
		// Verifying the male gender
		if (gender.equals("Male") && !mgender.isSelected()) {
			mgender.click();
			if (mgender.isSelected()) {
				System.out.println("Male gender is selected");
			}
			// Verifying the male gender
		} else if (gender.equals("Female") && !fgender.isSelected()) {
			fgender.click();
			if (fgender.isSelected()) {
				System.out.println("Female gender is selected");
			}
		}
	}

	// Sending DoB
	public void sendDoB(String DoB) {
		doB.clear();
		doB.sendKeys(DoB);
	}

	// Sending company name
	public void sendingCompanyName(String cname) {
		companyname.clear();
		companyname.sendKeys(cname);
	}

	// Verifying tax exempt
	public void taxExempt() {
		if (!taxexbtn.isSelected()) {
			taxexbtn.click();
		}
	}

	public void newsLetter(String nltetter) throws InterruptedException {
		newLetter.sendKeys(Keys.TAB);
		newLetter.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		if (nltetter.equals(newLetteropt1.getText())) {
			newLetter.sendKeys(Keys.DOWN);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(newLetteropt1));
			wait.until(ExpectedConditions.elementToBeClickable(newLetteropt1));
			newLetteropt1.click();
		} else if (nltetter.equals(newLetteropt2.getText())) {
			newLetter.sendKeys(Keys.DOWN);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(newLetteropt2));
			wait.until(ExpectedConditions.elementToBeClickable(newLetteropt2));
			newLetteropt2.click();
		}
	}

	public void selectingCustomerRole(String role) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(3000);
		customeroles.click();
//		customeroles.sendKeys(Keys.UP);
		for (WebElement roles : customerolesclick) {
//			customeroles.sendKeys(Keys.DOWN);
			if (roles.getText().equals(role)) {
				roles.click();

			} else {
				System.out.println("Doesnot match role");
			}
		}
	}

	public void selectingVendor(int vendor) {
		getManagerVendor().selectByIndex(vendor);

	}

	public void sendCommend(String commend) {
		addminComment.sendKeys(commend);
		savebtn.click();
		logoutbtn.click();

	}

}
