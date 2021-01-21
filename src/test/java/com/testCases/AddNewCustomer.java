package com.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.AddCustomerPage;
import com.pageObjects.CustomersPage;

public class AddNewCustomer extends BaseClass {
	public LoginTest test;
	public CustomersPage Cp;
	public AddCustomerPage Acp;

	@BeforeClass()
	public void Login() throws InterruptedException {
		test = new LoginTest();
		test.Logintest();
		SoftAssert softassert = new SoftAssert();
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			softassert.assertTrue(true);
			logger.info("Homepage page is displayed!");

		}
	}

	@Test
	public void AddNewcustomer() throws InterruptedException {
		Cp = new CustomersPage(driver);
		Acp = new AddCustomerPage(driver);
		Cp.Customermain();
		Cp.customerRole();
		Acp.addNewCustomerBtn();
		String emails = randomSring().toUpperCase() + "@gmail.com";
		String pwd = randomNum() + "*";
		String fname = randomSring();
		String lname = randomSring();

		Acp.sendEmailAddrs(emails);
		Acp.sendPassword(pwd);
		Acp.sendFName(fname);
		Acp.sendLname(lname);
		Acp.choosingGenderType("Male");
		Acp.sendDoB("12/31/2020");
		Acp.sendingCompanyName("BusyQA");
		Acp.newsLetter("Test store 2");
		Acp.selectingCustomerRole("Forum Moderators");
		Acp.selectingVendor(2);
		Acp.sendCommend("Hello dear Customer you are vey welcome to our online store. " + "\n"
				+ "We would be happy to serve you with our best effort.");

//		   

	}

}
