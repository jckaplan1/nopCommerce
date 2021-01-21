package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomersPage {
	WebDriver driver;

	public CustomersPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}

	// ===========================Capture Fields================

	// capture customere section
	@FindBy(xpath = "//div/ul/li[4]/a")
	@CacheLookup
	WebElement cstmBtn;

	// capture customer subsection
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	@CacheLookup
	WebElement customerrole;

	// capture search section in customer section
	@FindBy(xpath = "//div[contains(text(),'Search')]")
	@CacheLookup
	WebElement custsearch;

	// Cature the email field in customer search section
	@FindBy(id = "SearchEmail")
	@CacheLookup
	WebElement emailsearch;

	// Capture first name field in customer search section

	@FindBy(id = "SearchFirstName")
	@CacheLookup
	WebElement fnam;

	// Capture last name field in customer search section
	@FindBy(id = "SearchLastName")
	@CacheLookup
	WebElement lname;

	// Capture the the month in month filed
	@FindBy(id = "SearchMonthOfBirth")
	@CacheLookup
	WebElement month;

	public Select getSelectmonth() {
		return new Select(month);
	}

	// Capture the the day in day filed
	@FindBy(id = "SearchDayOfBirth")
	@CacheLookup
	WebElement day;

	public Select getSelectday() {
		return new Select(day);
	}

	// Capture the search button
	@FindBy(id = "search-customers")
	@CacheLookup
	WebElement serchbtn;

	// Capture all customers with their informations
	@FindBys(@FindBy(xpath = "//tbody/tr/td"))
	@CacheLookup
	List<WebElement> customerinformatin;

	// Capture logout button
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;

	// ======================Action methods============
	// Click on main customer icon
	public void Customermain() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(cstmBtn));
		wait.until(ExpectedConditions.elementToBeClickable(cstmBtn));
		cstmBtn.click();

	}

	// click on on sub customers icon for customers role
	public void customerRole() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(customerrole));
		wait.until(ExpectedConditions.elementToBeClickable(customerrole));
		customerrole.click();
	}

	// selecting birthday
	public void selectDay(int days) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(day));
		wait.until(ExpectedConditions.elementToBeClickable(day));
		getSelectday().selectByIndex(days);
		System.out.println(days + " is selected.");
	}

	// Selecting birth month
	public void selectMonth(int mont) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(month));
		wait.until(ExpectedConditions.elementToBeClickable(month));
		getSelectmonth().selectByIndex(mont);
		System.out.println(month + ". motnth is selected");
	}

	// Sending last name for search
	public void searcByLastName(String lsname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(lname));
		lname.sendKeys(lsname);
		for (WebElement info : customerinformatin) {
			if (info.getText().contains(lsname)) {
				System.out.println("The customer " + info.getText() + " is registered.");
			}
		}
	}

	// sending first name for research
	public void searcByFistName(String fsname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(fnam));
		fnam.sendKeys(fsname);
		for (WebElement info : customerinformatin) {
			if (info.getText().contains(fsname)) {
				System.out.println("The customer " + info.getText() + " is registered.");
			}
		}
	}

	public void clicksearcBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(serchbtn));
		serchbtn.click();

	}

	public void logoutBtn() {
		logoutbtn.click();

	}

}
