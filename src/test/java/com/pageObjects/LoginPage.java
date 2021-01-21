package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver ldriver;

	// constructor
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);// this==ldriver

	}

	// capture admin button
	@FindBy(xpath = "//a[@class='btn admin-button']")
	@CacheLookup
	WebElement admnbtn;

	// Capture email filed
	@FindBy(id = "Email")
	@CacheLookup
	WebElement emailtxt;

	// Capture password filed
	@FindBy(id = "Password")
	@CacheLookup
	WebElement passwtxt;

	// Capture login button
	@FindBy(xpath = "//form/div/input")
	@CacheLookup
	WebElement logbtn;

	// click login button
	public void adminbtn() {
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOf(admnbtn));
		wait.until(ExpectedConditions.elementToBeClickable(admnbtn));
		admnbtn.click();

	}

	// Sending Email
	public void sendEmail(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOf(emailtxt));
		emailtxt.clear();
		emailtxt.sendKeys(email);

	}

	public void sendPassword(String password) {
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOf(passwtxt));
		passwtxt.clear();
		passwtxt.sendKeys(password);

	}

	public void loginbtn() {
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOf(logbtn));
		logbtn.click();
	}

}
